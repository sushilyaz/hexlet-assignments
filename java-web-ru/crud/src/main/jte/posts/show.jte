@import exercise.util.NamedRoutes;
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h2>${page.getPost().getName()}</h2>
            <h4>${page.getPost().getBody()}</h4>
        </main>
    </div>
`
)
