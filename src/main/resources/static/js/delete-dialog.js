export default class DeleteDialog {
  constructor() {
    this.dialog = document.getElementById("delete-dialog");
    this.actualItem = document.getElementById("actual-item");
    this.cancelButton = document.getElementById("cancel-deletion");
    this.hiddenIdInput = document.getElementById("itemid");

    this.cancelButton.addEventListener("click", (e) => {
      e.preventDefault();
      this.toggleVisibility();
    });
  }

  setItemId = (id) => {
    this.hiddenIdInput.value = id;
  };

  toggleVisibility = () => {
    this.dialog.classList.toggle("hide");
  };

  setActualItem = (text) => {
    this.actualItem.innerHTML = text;
  };
}
