@template.layout.page(
content = @`
    <form action="/users" method="post">

        <form class="row g-3">
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Name</label>
                <input type="text" class="form-control" id="inputEmail4" required name="firstName">
            </div>
            <br>
            <div class="col-md-6">
                <label for="inputPassword4" class="form-label">Surname</label>
                <input type="text" class="form-control" id="inputPassword4" required name="lastName">
            </div>
            <br>
            <div class="col-md-6">
                <label for="inputAddress" class="form-label">Email</label>
                <input type="email" class="form-control" id="inputAddress" placeholder="For example: pupkin@gmail.com" required name="email">
            </div>
            <br>
            <div class="col-md-6">
                <label for="inputAddress2" class="form-label">Password</label>
                <input type="text" class="form-control" id="inputAddress2" required name="password">
            </div>
            <br>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>


    </form>
`
)
