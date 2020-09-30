import NoteForm from "./note-form.js";
import Menu from "./menu.js";
import Toast from "./toast.js";
import DeleteDialog from "./delete-dialog.js";

const menu = new Menu();
const toast = new Toast();
const noteForm = new NoteForm();
const deleteDialog = new DeleteDialog();

// Check if error occured during filling out information
const errorNote = document.getElementsByClassName("error-note")[0];
if (errorNote != null) {
  noteForm.toggleVisibility();
  noteForm.setSubmitButtonText("Update");
  noteForm.setHeadingText("Update note");
}

// Note Button
const createNoteButton = document.getElementsByClassName("create-note")[0];
createNoteButton.addEventListener("click", (e) => {
  e.preventDefault();
  noteForm.toggleVisibility();
  noteForm.clearFormInputs;
  noteForm.setSubmitButtonText("Create");
  noteForm.setHeadingText("Create note");
});

// Find all edit notes from table and set up click handler
const editNotes = document.getElementsByClassName("data-edit");
if (editNotes != null) {
  for (let i = 0; i < editNotes.length; i++) {
    editNotes[i].addEventListener("click", (e) => {
      e.preventDefault();
      const item_id = e.target.getAttribute("data-edit-id");
      const title_text = e.target.getAttribute("data-edit-title");
      const description_text = e.target.getAttribute("data-edit-description");

      noteForm.toggleVisibility();
      noteForm.setDescription(description_text);
      noteForm.setId(item_id);
      noteForm.setSubmitButtonText("Update");
      noteForm.setHeadingText("Update note");
      noteForm.setTitle(title_text);
    });
  }
}

//
const deleteNotes = document.getElementsByClassName("data-delete");
if (deleteNotes != null) {
  for (let i = 0; i < deleteNotes.length; i++) {
    deleteNotes[i].addEventListener("click", (e) => {
      e.preventDefault();

      const item_id = e.target.getAttribute("data-delete-id");
      const item_title = e.target.getAttribute("data-delete-item");

      deleteDialog.toggleVisibility();
      deleteDialog.setItemId(item_id);
      deleteDialog.setActualItem(item_title);
    });
  }
}
