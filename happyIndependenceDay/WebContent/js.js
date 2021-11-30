
var id = 0;
setInterval(
	function() {
		var flags = [
			"http://hdwallpapersbackgrounds.us/backgrounds-image/wallpapers-hd-4s-2560x1600/hd-wallpapers-desktop-3196pg612-4s-2560x1600.jpg",
			"https://wallpaperstock.net/india-flag-wallpapers_32961_1920x1200.jpg",
			"https://atulhost.b-cdn.net/wp-content/uploads/2019/07/flag-of-india-full-hd-with-visual-effects-1536x864.jpg",
			"http://www.cfo-india.in/sites/default/files/India%20pic_3.JPG",
			"https://i.ytimg.com/vi/ghsVNNYrOgQ/maxresdefault.jpg",
			"https://www.desktopbackground.org/download/1600x900/2015/06/06/960049_20-happy-independence-day-wallpapers-images-pictures-free_1920x1200_h.jpg",
			"https://i.ytimg.com/vi/QhoJ6cDfI40/maxresdefault.jpg"];
		document.getElementById("flags").src = flags[id];
		id++
		if (id > 6) {	
			id = 0;
		}
	}, 2000);


