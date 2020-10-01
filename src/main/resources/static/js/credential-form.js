export default class CredentialForm {
  constructor() {
    // Form elements
    this.noteForm = document.getElementsByClassName("edit-credential")[0];
    this.url = document.getElementById("url");
    this.username = document.getElementById("username");
    this.password = document.getElementById("password");
    this.id_element = document.getElementById("id");

    // Buttons
    this.cancelButton = document.getElementById("cancel");
    this.submitButton = document.getElementById("submit");

    // H1 element
    this.heading = document.getElementById("credential-heading");

    this.cancelButton.addEventListener("click", (e) => {
      e.preventDefault();
      this.clearFormInputs();
      this.toggleVisibility();
    });

    this.errorUrl = document.getElementById("error-url");
    this.errorUsername = document.getElementById("error-username");
    this.errorPassword = document.getElementById("error-password");
  }

  clearFormInputs = () => {
    this.url.value = null;
    this.username.value = null;
    this.password.value = null;
    this.id_element.value = null;

    if (this.errorUrl != null) {
      this.errorUrl.id = "hide";
    }

    if (this.errorUsername != null) {
      this.errorUsername.id = "hide";
    }

    if (this.errorPassword != null) {
      this.errorPassword = "hide";
    }
  };

  toggleVisibility = () => {
    this.noteForm.classList.toggle("hide");
  };

  setUrl = (url) => {
    this.url.value = url;
  };

  setUsername = (username) => {
    this.username.value = username;
  };

  setId = (id) => {
    this.id_element.value = id;
  };

  setPassword = (password) => {
    this.password.value = password;
  };

  setSubmitButtonText = (text) => {
    this.submitButton.innerHTML = text;
  };

  setHeadingText = (text) => {
    this.heading.innerHTML = text;
  };
}
