var slideimages = new Array()
slideimages[1] = new Image()
slideimages[1].src = "/Images/C.jpg"
slideimages[2] = new Image()
slideimages[2].src = "/Images/java.jpg"
slideimages[0] = new Image()
slideimages[0].src = "/Images/Capture.jpg"

var step=0

function slideit(){

 if (!document.images)
  return
 document.getElementById('slide').src = slideimages[step].src
 if (step<2)
  step++
 else
  step=0

 setTimeout("slideit()",2500)
}

slideit()
