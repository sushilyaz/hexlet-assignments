@import exercise.dto.users.UsersPage;
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    <h2>Фильтр</h2>
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search">
    </form>
    <table>
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    ${user.getFirstName()} ${user.getLastName()}
                </td>
            </tr>
        @endfor
    </table>
`
)
