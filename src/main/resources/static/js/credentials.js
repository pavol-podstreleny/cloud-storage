import Menu from "./menu.js";
import Toast from "./toast.js";
import DeleteDialog from "./delete-dialog.js";
import CredentialForm from "./credential-form.js";

const menu = new Menu();
const toast = new Toast();
const deleteDialog = new DeleteDialog();
const credentialForm = new CredentialForm();

// Check if error occured during filling out information
const errorNote = document.getElementsByClassName("error-note")[0];
if (errorNote != null) {
  credentialForm.toggleVisibility();
  credentialForm.setSubmitButtonText("Update");
  credentialForm.setHeadingText("Update credential");
}

// Note Button
const createNoteButton = document.getElementsByClassName(
  "create-credential"
)[0];
createNoteButton.addEventListener("click", (e) => {
  e.preventDefault();

  credentialForm.toggleVisibility();
  credentialForm.clearFormInputs();
  credentialForm.setSubmitButtonText("Create");
  credentialForm.setHeadingText("Create credential");
});

// Find all edit notes from table and set up click handler
const editCredentials = document.getElementsByClassName("data-edit");
if (editCredentials != null) {
  for (let i = 0; i < editCredentials.length; i++) {
    editCredentials[i].addEventListener("click", (e) => {
      e.preventDefault();

      const item_id = e.target.getAttribute("data-edit-id");
      const url_text = e.target.getAttribute("data-edit-url");
      const username_text = e.target.getAttribute("data-edit-username");
      const password_decripted = e.target.getAttribute("data-edit-password");

      credentialForm.toggleVisibility();
      credentialForm.setUrl(url_text);
      credentialForm.setUsername(username_text);
      credentialForm.setPassword(password_decripted);
      credentialForm.setId(item_id);

      credentialForm.setSubmitButtonText("Update");
      credentialForm.setHeadingText("Update credential");
    });
  }
}

const deleteCredentials = document.getElementsByClassName("data-delete");
if (deleteCredentials != null) {
  for (let i = 0; i < deleteCredentials.length; i++) {
    deleteCredentials[i].addEventListener("click", (e) => {
      e.preventDefault();

      const item_id = e.target.getAttribute("data-delete-id");
      const item_title = e.target.getAttribute("data-delete-item");

      deleteDialog.toggleVisibility();
      deleteDialog.setItemId(item_id);
      deleteDialog.setActualItem(item_title);
    });
  }
}
