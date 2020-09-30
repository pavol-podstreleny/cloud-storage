export default class Menu {
  constructor() {
    this.menuButton = document.getElementById("menu-icon");
    this.closeMenuButton = document.getElementById("menu-close-icon");
    this.mainNavigation = document.getElementsByClassName("main-nav")[0];

    this.menuButton.addEventListener("click", (e) => {
      this.mainNavigation.classList.toggle("open");
      e.stopPropagation();
    });

    this.mainNavigation.addEventListener("click", (e) => {
      this.mainNavigation.toggle("open");
      e.stopPropagation();
    });
  }
}
