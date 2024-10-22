
/*const webCamElement = document.getElementById("webCam");
const canvasElement = document.getElementById("canvas");
const webcam = new Webcam(webCamElement,"user",canvasElement);
webcam.start();

function takeAPicture(){
	let picture = webcam.snap();
	document.querySelector("a").href = picture;
}*/


const followButtons = document.querySelectorAll('.followbutton');

followButtons.forEach((btn) => {
	btn.addEventListener("click", (e) => followUnFollow(e.target));
});

function followUnFollow(button) {
	button.classList.toggle("followed");
	
	// Trim spaces and use strict comparison
	if(button.innerText.trim() === "Follow") {
		button.innerText = "Unfollow";
	} else {
		button.innerText = "Follow";
	}
	console.log("JavaScript file loaded and executed");
}



//SEARCH BAR javascript


let availableKeywords = [
    'mehandi design',
    'sister love',
    'anarkali dresses',
    'virat kohli',
    'decoration',
];

const resultsBox = document.querySelector(".result-box");
const inputBox = document.getElementById("input-box");

inputBox.onkeyup = function(){
    let result = [];
    let input = inputBox.value;
    if(input.length){
        result = availableKeywords.filter((keyword)=>{
            return keyword.toLowerCase().includes(input.toLowerCase());

        });
        console.log(result);
    }
    display(result);

    if(!result.length){
        resultsBox.innerHTML = '';
    }
}

function display(result){
    const content = result.map((list)=>{
        return"<li onclick = selectInput(this)>" + list + "</li>";

    });
    resultsBox.innerHTML = "<ul>" + content.join('') + "</ul>";
}

function selectInput(list){
    inputBox.value = list.innerHTML;
    resultsBox.innerHTML = '';
}