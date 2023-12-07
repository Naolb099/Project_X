function show_hide() {
    var click = document.getElementById("list-items");
    if (click.style.display === "" || click.style.display === "none") {
        click.style.display = "block";
    } else {
        click.style.display = "none";
    }
}
document.addEventListener('DOMContentLoaded', (event) => {
    document.querySelectorAll('.post-body').forEach(postBody => {
        postBody.addEventListener('click', function() {
            this.classList.toggle('expanded');
        });
    });
});


