@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif

        <form action="/articles" method="post" class="row g-3">
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Title</label>
                <input type="text" class="form-control" id="inputEmail4" required name="title" value="${page.getTitle()}">
            </div>
            <br>
            <div class="form-floating">
                <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px" required name="content">${page.getContent()}</textarea>
                <label for="floatingTextarea2">Comments</label>
            </div>
            <br>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Отправить</button>
            </div>
        </form>
    `
)
