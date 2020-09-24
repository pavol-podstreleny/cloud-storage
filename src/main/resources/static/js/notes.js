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

// Deletion box
const wholeBackground = document.getElementsByClassName("deletion")[0];
const cancelButton = document.getElementById("cancel");
cancelButton.addEventListener("click", (e) => {
  e.preventDefault();
  e.stopPropagation();
  wholeBackground.classList.toggle("hide");
});

// Note button - form
// const noteForm = document.getElementById("note-form");

const createNoteButton = document.getElementsByClassName("create-note")[0];
if (createNoteButton != null) {
  createNoteButton.addEventListener("click", (e) => {
    e.preventDefault();
    console.log("click");
    wholeBackground.classList.toggle("hide");
  });
}
