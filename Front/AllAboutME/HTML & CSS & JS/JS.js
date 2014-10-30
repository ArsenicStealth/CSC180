var slideimages = new Array()
slideimages[1] = new Image()
slideimages[1].src = "/Images/Slide/79656.jpg"
slideimages[2] = new Image()
slideimages[2].src = "/Images/Slide/245876.jpg"
slideimages[3] = new Image()
slideimages[3].src = "/Images/Slide/294112.jpg"
slideimages[0] = new Image()
slideimages[0].src = "/Images/Slide/badass.jpg"
slideimages[4] = new Image()
slideimages[4].src = "/Images/Slide/Darksiders.jpg"
slideimages[5] = new Image()
slideimages[5].src = "/Images/Slide/a1a69ce46e1973fd2f94aea3c50e68a9.jpg"
slideimages[6] = new Image()
slideimages[6].src = "/Images/Slide/af1986c0e238abe8885b06b37d7453a2.jpg"
slideimages[7] = new Image()
slideimages[7].src = "/Images/Slide/fallout_brotherhood_of_steel_new_vegas_3_ranger_1920x1080_52759.jpg"
slideimages[8] = new Image()
slideimages[8].src = "/Images/Slide/IMG_20140628_153712587.jpg"
slideimages[9] = new Image()
slideimages[9].src = "/Images/Slide/IMG_20140628_153745196.jpg"
slideimages[10] = new Image()
slideimages[10].src = "/Images/Slide/IMG_20140813_195848566.jpg"
var step=0

function slideit(){

 if (!document.images)
  return
 document.getElementById('slide').src = slideimages[step].src
 if (step<10)
  step++
 else
  step=0

 setTimeout("slideit()",2500)
}

slideit()
