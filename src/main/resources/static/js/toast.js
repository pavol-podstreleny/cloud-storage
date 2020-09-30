export default class Toast {
  constructor() {
    // Hide the toast showing the error / success after few seconds
    this.toast = document.getElementsByClassName("toast");
    if (this.toast != null && this.toast.length > 0) {
      setTimeout(() => {
        this.toast[0].classList.toggle("close");
      }, 3000);
    }
  }
}
