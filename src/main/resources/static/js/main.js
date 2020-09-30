const menu = document.getElementById("menu-icon");
const closeMenu = document.getElementById("menu-close-icon");
const nav = document.getElementsByClassName("main-nav")[0];

menu.addEventListener("click", (e) => {
  nav.classList.toggle("open");
  e.stopPropagation();
});

closeMenu.addEventListener("click", (e) => {
  nav.classList.toggle("open");
  e.stopPropagation();
});

/* FILE LOADING */

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

// Hide the toast showing the error / success after few seconds

const toast = document.getElementsByClassName("toast");
if (toast != null) {
  setTimeout(() => {
    console.log("Fired");
    toast[0].classList.toggle("close");
  }, 3000);
}

// Deletion box
const wholeBackground = document.getElementsByClassName("form-focus")[0];
const cancelButton = document.getElementById("cancel");
cancelButton.addEventListener("click", (e) => {
  e.preventDefault();
  e.stopPropagation();
  wholeBackground.classList.toggle("hide");
});

const fileIDInput = document.getElementById("fileID");
const fileIDSpan = document.getElementById("fileIDSpan");

// Delete data table click
const allData = document.getElementsByClassName("data-delete");
if (allData != null) {
  for (let i = 0; i < allData.length; i++) {
    allData[i].addEventListener("click", (e) => {
      const file_id = e.target.getAttribute("data-delete");
      const file_name = e.target.getAttribute("data-name");
      wholeBackground.classList.toggle("hide");

      if (fileIDInput != null && fileIDSpan != null) {
        fileIDInput.value = file_id;
        fileIDSpan.innerHTML = file_name;
      }
    });
  }
}
