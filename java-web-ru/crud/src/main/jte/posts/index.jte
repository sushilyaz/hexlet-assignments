@import exercise.util.NamedRoutes;
@import exercise.dto.posts.PostsPage
@param PostsPage page
@param Integer numOfPage

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <ol>
                @for(var post : page.getPosts())
                    <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
                @endfor
            </ol>
        </main>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${numOfPage-1}">Previous</a></li>
            <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}?page=${numOfPage+1}">Next</a></li>
        </ul>
    </nav>
`
)
