    <form action="insertBooks" method="post">
        <div class="insertContainer">
            <div class="headins">
                <span class="insmainhead">here you can add Books</span>
            </div>
            <div class="insInputs">
                <input type="text" name="name" placeholder="Enter Books Name" required="required" autocomplete="off">
                <input type="text" name="author" placeholder="Enter Author Name" required="required" autocomplete="off">
                <input type="number" name="edition" placeholder="Enter Edition" required="required" autocomplete="off">
                <input type="number" name="price" placeholder="Eneter Price" required="required" autocomplete="off">
                <input type="number" name="quantity" placeholder="Quantity" required="required" autocomplete="off">
                <input type="number" name="code" placeholder="Enter Code" required="required" autocomplete="off">
                <input type="url" name="url" placeholder="Enter URL of Image" required="required" autocomplete="off">
            </div>
            <div class="insButtons">
                <input type="Submit" value="Insert">
                <a href="javascript:fetchdata('Main')">Cancel</a>
            </div>
        </div>
     </form>