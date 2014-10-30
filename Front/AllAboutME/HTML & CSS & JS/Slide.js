var slideimages = new Array()
slideimages[1] = new Image()
slideimages[1].src = "/Images/Done.png"
slideimages[2] = new Image()
slideimages[2].src = "/Images/BC.png"
slideimages[3] = new Image()
slideimages[3].src = "/Images/Capture.jpg"
slideimages[0] = new Image()
slideimages[0].src = "/Images/Lab-1.gif"
slideimages[4] = new Image()
slideimages[4].src = "/Images/demolayemblem.jpg"

var step=0

function slideit(){

 if (!document.images)
  return
 document.getElementById('slide').src = slideimages[step].src
 if (step<4)
  step++
 else
  step=0

 setTimeout("slideit()",2500)
}

slideit()
