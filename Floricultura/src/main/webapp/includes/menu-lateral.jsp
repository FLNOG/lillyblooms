<!-- <%@ page import="model.Cliente" %> -->

<link rel="stylesheet" href="includes/menu-lateral.css">

<nav>
    <div class="menu-lateral">
        <h1>Home | Minha Conta</h1>
            <h2>OLÁ ${cliente.nome}</h2>
       
        <ul>
            <li><a href="perfil.jsp"><i><img src="img/pessoa.jpg" /></i> Dados da Minha Conta</a></li>
            <li><a href="pedidos.jsp"><i><img src="img/pacote.jpg" /></i> Meus Pedidos</a></li>
            <li><a href="enderecos.jsp"><i><img src="img/mapa.jpg" /></i> Meus Endereços</a></li>
            <li><a href="alterar-senha.jsp"><i><img src="img/cadeado.jpg" /></i> Alterar Minha Senha</a></li>
            <li><a href="alterar-email.jsp"><i><img src="img/email.jpg" /></i> Alterar Meu E-mail</a></li>
            <li><a href="Logoff"><i><img src="img/sair.jpg" /></i> Sair</a></li>
        </ul>
    </div>
</nav>