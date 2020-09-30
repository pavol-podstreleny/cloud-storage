export default class NoteForm {
  constructor() {
    // Form elements
    this.noteForm = document.getElementsByClassName("edit-note")[0];
    this.title = document.getElementById("title");
    this.description = document.getElementById("description");
    this.id_element = document.getElementById("id");

    // Buttons
    this.cancelButton = document.getElementById("cancel");
    this.submitButton = document.getElementById("submit");

    // H1 element
    this.heading = document.getElementById("note-heading");

    this.cancelButton.addEventListener("click", (e) => {
      e.preventDefault();
      this.clearFormInputs();
      this.toggleVisibility();
    });

    this.errorTitle = document.getElementById("error-title");
    this.errorDescription = document.getElementById("error-description");
  }

  clearFormInputs = () => {
    this.title.value = null;
    this.description.value = null;
    this.description.innerHTML = null;
    this.id_element.value = null;

    if (this.errorTitle != null) {
      this.errorTitle.id = "hide";
    }

    if (this.errorDescription != null) {
      this.errorDescription.id = "hide";
    }
  };

  toggleVisibility = () => {
    this.noteForm.classList.toggle("hide");
  };

  setTitle = (title) => {
    this.title.value = title;
  };

  setDescription = (description) => {
    // Description represents textarea
    this.description.value = description;
    this.description.innerHTML = description;
  };

  setId = (id) => {
    this.id_element.value = id;
  };

  setSubmitButtonText = (text) => {
    this.submitButton.innerHTML = text;
  };

  setHeadingText = (text) => {
    this.heading.innerHTML = text;
  };
}
