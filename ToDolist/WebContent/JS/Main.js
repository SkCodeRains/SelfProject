/**
 * 
 */


function runAble() {
	var choice = document.getElementsByClassName('Container');
	var dragItem = null;
	var parentId = null;
	var dropedId = null;
	var p = document.getElementsByClassName("dragg");
	var pp = document.getElementsByTagName("p");
	for (var i of pp) {
		i.addEventListener("dblclick", editUpdateTask1);
	}
	for (var i of p) {

		i.addEventListener('dragstart', dragstart);
		i.addEventListener('dragend', dragend);
	}
	function editUpdateTask1() {
		var elemn = this;
		var id = elemn.id;
		var text = elemn.textContent;
		var divid = elemn.parentElement;
		editUpdateTask(id, text, divid.parentElement.id);

	}

	function dragstart() {
		dragItem = this;
		parentId = this.parentElement.id;
	}

	function dragend() {
		if (dropedId != null) {
			if (parentId != dropedId) {
				var ss = dragItem.children;
				movedata(ss[1].id, parentId, dropedId);
			}
		}

		parentId = null;
		dropedId = null;
		dragItem = null;
	}

	for (j of choice) {
		j.addEventListener('dragover', dragover);
		j.addEventListener('dragenter', dragenter);
		j.addEventListener('dragleave', dragleave);
		j.addEventListener('drop', drop);
	}

	function drop() {
		this.append(dragItem);
		dropedId = this.id;
	}

	function dragover(e) {
		try {
			if (this.id != parentId) {
				e.preventDefault();
			}
		} catch (error) {

		}
		if (parentId == null) {
			e.preventDefault();
		}

	}


	function dragenter(e) {
		try {
			if (this.id != parentId) {
				e.preventDefault();
			}
		} catch (error) {

		}

	}


	function dragleave() { }






}

function removeDiv() {
	document.getElementById('EditeDiv').remove();
}