@import exercise.dto.MainPage
@import exercise.util.NamedRoutes;
@param MainPage page
@template.layout.page(
    content = @`
    @if(page.getName() == null)
        <div class="mx-auto p-4 py-md-5">
            <main>
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            </main>
        </div>
    @endif
    @if(page.getName() != null)
        <div class="mx-auto p-4 py-md-5">
            <main>
                ${page.getName().toString()}
                <a href="${NamedRoutes.logoutPath()}">Выйти</a>
            </main>
        </div>
    @endif
    `
    )