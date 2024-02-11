"use strict";

fetch('/onLoadIndex')
    .then((response) => response.json())
    .then((data) => completePage(data));


let completePage = (data) => {
    completeCategoryCaptions(data.categories);
    completeCategoryImages(data.categories);
    completeBrandImages(data.brands);
}

let completeCategoryCaptions = (categories) => {
    let captions = document.querySelectorAll(".group_caption");
    for (let i = 0; i < captions.length; i++) {
        captions[i].innerHTML = `<p>${categories[i]}</p>`;
    }
}

let completeCategoryImages = (categories) => {
    let imageDivs = document.querySelectorAll(".group_img");
    let img;
    for (let i = 0; i < imageDivs.length; i++) {
        img = imageDivs[i].querySelector("img");
        img.src = `img/categories/${categories[i]}.jpg`;
    }
}

let completeBrandImages = (brand) => {
    let brandDivs = document.querySelectorAll(".brand");
    for (let i = 0; i < brandDivs.length; i++) {
        brandDivs[i].innerHTML = `<img src=img/brands/${brand[i]}.png alt="${brand[i]}" class="brand-img">`;
    }
}


