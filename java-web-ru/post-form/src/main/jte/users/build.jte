@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div>
            <label>
                Имя
                <input type="text" required name="first_name" />
            </label>
        </div>
        <div>
            <label>
                Фамилия
                <input type="text" required name="last_name" />
            </label>
        </div>
        <div>
            <label>
                Электронная почта
                <input type="email" required name="email" />
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="password" requiredname="password" />
            </label>
        </div>
        <input type="submit" value="Зарегистрировать" />
    </form>
`
)
