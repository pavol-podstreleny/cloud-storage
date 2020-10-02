package com.pavolpodstreleny.CloudStorage.service;

import com.pavolpodstreleny.CloudStorage.entity.Credential;
import com.pavolpodstreleny.CloudStorage.entity.CredentialForm;
import com.pavolpodstreleny.CloudStorage.mapper.CredentialMapper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {

    private final CredentialMapper credentialMapper;

    private final EncryptionService encryptionService;

    public CredentialService(final CredentialMapper credentialMapper, final EncryptionService encryptionService) {
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public List<Credential> provideCredentials(int userId) {
        final List<Credential> credentials = credentialMapper.getCredentials(userId);
        for (Credential credential : credentials) {
            credential.setPasswordDecrypted(decrypt(credential.getPasswordEncrypted(), credential.getKey()));
        }
        return credentials;
    }

    public Credential provideCredential(int userId, int credentialId) {
        return credentialMapper.getCredential(userId, credentialId);
    }

    public int removeCredential(int credentialId) {
        return credentialMapper.delete(credentialId);
    }

    public int updateCredential(CredentialForm credentialForm) {
        Credential credential = provideCredential(credentialForm.getUserId(), credentialForm.getId());
        if (credential == null)
            return -1;
        credential.setUserName(credentialForm.getUsername());
        credential.setUrl(credentialForm.getUrl());
        credential.setPasswordEncrypted(
                encryptionService.encryptValue(credentialForm.getPassword(), credential.getKey()));
        return credentialMapper.update(credential);
    }

    public int createCredential(CredentialForm credentialForm) {
        // Generate encoded key
        String encodedKey = generateEncodedKey();
        String encryptedPassword = encryptionService.encryptValue(credentialForm.getPassword(), encodedKey);
        Credential credential = new Credential(credentialForm.getUrl(), credentialForm.getUsername(), encodedKey,
                encryptedPassword, credentialForm.getUserId());
        return credentialMapper.insert(credential);
    }

    private String decrypt(String encryptedPassword, String key) {
        return encryptionService.decryptValue(encryptedPassword, key);
    }

    private String generateEncodedKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}