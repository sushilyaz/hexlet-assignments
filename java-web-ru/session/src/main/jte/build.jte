@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param String error
@if(error!=null)
${error}
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Nickname" name="name" />
    <input type="password" placeholder="Password" name="password" />
    <input type="submit" />
</form>