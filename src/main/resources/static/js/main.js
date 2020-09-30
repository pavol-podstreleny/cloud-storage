import Menu from "./menu.js";
import Toast from "./toast.js";
import DeletionDialog from "./delete-dialog.js";

/* FILE LOADING */

const menu = new Menu();
const toast = new Toast();
const deletionDialog = new DeletionDialog();

const submitButton = document.getElementById("submit-button");
const uploadFileInput = document.getElementById("uploadFile");

uploadFileInput.addEventListener("change", (e) => {
  submitButton.click();
});

const dropArea = document.getElementById("drag-and-drop");
dropArea.addEventListener("dragover", (event) => {
  event.stopPropagation();
  event.preventDefault();
  // Style the drag-and-drop as a "copy file" operation.
  event.dataTransfer.dropEffect = "copy";
});

dropArea.addEventListener("drop", (event) => {
  event.stopPropagation();
  event.preventDefault();
  uploadFileInput.files[0] = event.dataTransfer.files[0];
  submitButton.click();
});

// Delete data table click
const allData = document.getElementsByClassName("data-delete");
if (allData != null) {
  for (let i = 0; i < allData.length; i++) {
    allData[i].addEventListener("click", (e) => {
      const file_id = e.target.getAttribute("data-delete");
      const file_name = e.target.getAttribute("data-name");
      deletionDialog.toggleVisibility();
      deletionDialog.setItemId(file_id);
      deletionDialog.setActualItem(file_name);
    });
  }
}
