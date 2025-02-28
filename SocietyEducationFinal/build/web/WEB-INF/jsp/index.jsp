<%-- 
    Document   : index
    Created on : 27 de nov. de 2024, 16:57:06
    Author     : leand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Society education</title>



  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" />
  <!-- progress barstle -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/css-circular-prog-bar.css">
  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
  <!-- font wesome stylesheet -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="${pageContext.request.contextPath}/resources/assets/css/responsive.css" rel="stylesheet" />




  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/css-circular-prog-bar.css">


</head>

<body>
  <div class="top_container">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index">
            <img src="images/logo.png" alt="">
            <span>
              Society Education
            </span>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex ml-auto flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
                <li class="nav-item active">
                  <a class="nav-link" href="index"> Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item ">
                  <a class="nav-link" href="about"> Sobre Nós </a>
                </li>

        
                <li class="nav-item">
                  <a class="nav-link" href="contact">Contato</a>
                </li>

              </ul>
              <form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0">
                <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
              </form>
            </div>
        </nav>
      </div>
    </header>
    <section class="hero_section ">
      <div class="hero-container container">
        <div class="hero_detail-box">
          <h3>
            Bem vindo ao melhor sistema <br>
            de Educação do Brasil
          </h3>
       
          <p>
            O sistema visa melhorar a disciplina escolar, priorizando o diálogo e a reflexão sobre as atitudes dos alunos. Busca criar um ambiente respeitoso e justo, envolvendo toda a comunidade escolar no processo.
          </p>
          <div class="hero_btn-continer">
            <a href="login" class="call_to-btn btn_white-border">
              <span>
                   Login
              </span>
              <img src="${pageContext.request.contextPath}/resources/assets/images/right-arrow.png" alt="">
            </a>
          </div>
        </div>
        <div class="hero_img-container">
          <div>
            <img src="${pageContext.request.contextPath}/resources/assets/images/hero.png" alt="" class="img-fluid">
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- end header section -->

  <!-- about section -->
  <section class="about_section layout_padding">
    <div class="container">
      <h2 class="main-heading ">
        Sobre nosso sistema 
      </h2>
      <p class="text-center">
        Por meio da implementação de ferramentas e práticas inovadoras, o sistema visa não apenas identificar comportamentos inadequados, mas também oferecer soluções educativas que permitam aos estudantes refletir sobre suas ações e entender suas consequências. A abordagem é centrada no diálogo e na orientação, ao invés de punições severas, criando um clima de confiança e empatia entre educadores e alunos.

        Além disso, o sistema valoriza a transparência e a participação de todos os envolvidos — desde professores e gestores até os próprios alunos e suas famílias. Com isso, espera-se que o processo disciplinar seja mais justo, eficaz e alinhado com os princípios de cidadania e respeito, contribuindo para o desenvolvimento integral dos estudantes e para a melhoria do ambiente escolar como um todo.
      </p>
      <div class="about_img-box ">
        <img src="${pageContext.request.contextPath}/resources/assets/images/kids.jpg" alt="" class="img-fluid w-100">
      </div>
      <div class="d-flex justify-content-center mt-5">
        <a href="" class="call_to-btn  ">

          <span>
            saber mais 
          </span>
          <img src="${pageContext.request.contextPath}/resources/assets/images/right-arrow.png" alt="">
        </a>
      </div>
    </div>
  </section>


  <!-- about section -->

  <!-- teacher section -->
 

  <!-- teacher section -->

  


  <!-- vehicle section -->
  <!-- client section -->
  <section class="client_section layout_padding">
    <div class="container">
      <h2 class="main-heading ">
avaliação do nosso sistema      </h2>
      <p class="text-center">
        Eu estou muito satisfeito com o funcionamento do sistema que foi implementado na nossa escola. Ele trouxe uma série de melhorias importantes para o dia a dia de todos. Primeiramente, a organização das informações ficou muito mais eficiente. Agora, é possível acessar dados como horários de aulas, notas e comunicados de maneira rápida e intuitiva, sem precisar ficar buscando em diferentes plataformas ou esperando por respostas demoradas.
      </p>
      <div class="layout_padding2">
        <div class="client_container d-flex flex-column">
          <div class="client_detail d-flex align-items-center">
            <div class="client_img-box ">
              <img src="${pageContext.request.contextPath}/resources/assets/images/student.png" alt="">
            </div>
            <div class="client_detail-box">
              <h4>
Cricia               </h4>
              <span>
                (Diretora)
              </span>
            </div>
          </div>
          <div class="client_text mt-4">
            <p>
              "Eu estou muito satisfeito com o funcionamento do sistema que foi implementado na nossa escola. Ele trouxe uma série de melhorias importantes para o dia a dia de todos. Primeiramente, a organização das informações ficou muito mais eficiente. Agora, é possível acessar dados como horários de aulas, notas e comunicados de maneira rápida e intuitiva, sem precisar ficar buscando em diferentes plataformas ou esperando por respostas demoradas.


            </p>
          </div>
        </div>
      </div>
    </div>
  </section>




  <!-- client section -->

  <!-- contact section -->

  <section class="contact_section layout_padding-bottom">
    <div class="container">
      <h2 class="main-heading">
        entrar em contato
      </h2>
      <p class="text-center">
        caso tenha alguma dúvida ou problema entrar em contato conosco
      </p>
      <div class="">
        <div class="contact_section-container">
          <div class="row">
            <div class="col-md-6 mx-auto">
              <div class="contact-form" style="background-color: #223797; color: #000; padding: 20px; border-radius: 8px;">
                <form action="">
                  <!-- Campo Nome -->
                  <div>
                    <label for="name" style="color: #ffffff; font-weight: bold;">Nome</label>
                    <input id="name" type="text" placeholder="Digite seu nome" style="background-color: #ffffff; color: #000; border: none; padding: 10px; width: 100%; margin-bottom: 10px;">
                  </div>
                  <!-- Campo Email -->
                  <div>
                    <label for="email" style="color: #ffffff; font-weight: bold;">Email</label>
                    <input id="email" type="email" placeholder="Digite seu email" style="background-color: #ffffff; color: #000; border: none; padding: 10px; width: 100%; margin-bottom: 10px;">
                  </div>
                  <!-- Campo Telefone -->
                  <div>
                    <label for="phone" style="color: #ffffff; font-weight: bold;">Telefone</label>
                    <input id="phone" type="text" placeholder="Digite seu telefone" style="background-color: #ffffff; color: #000; border: none; padding: 10px; width: 100%; margin-bottom: 10px;">
                  </div>
                  <!-- Campo Descrição -->
                  <div>
                    <label for="description" style="color: #ffffff; font-weight: bold;">Descrição</label>
                    <textarea id="description" placeholder="Digite sua mensagem" style="background-color: #ffffff; color: #000; border: none; padding: 10px; width: 100%; margin-bottom: 10px; height: 100px;"></textarea>
                  </div>
                  <!-- Botão Enviar -->
                  <div class="d-flex justify-content-center">
                    <button type="submit" class="btn_on-hover" style="background-color: #ffeb3b; color: #000; padding: 10px 20px; border: none; border-radius: 5px; font-weight: bold;">
                      enviar!
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
  
  





  <!-- admission section -->


  <!-- landing section -->
  

  <!-- end landing section -->




  <!-- footer section -->
  <section class="container-fluid footer_section">
    <p>
      Copyright &copy; 2019 All Rights Reserved By
      <a href="https://html.design/">Free Html Templates</a>
    </p>
  </section>
  <!-- footer section -->

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.js"></script>

  <script>
    // This example adds a marker to indicate the position of Bondi Beach in Sydney,
    // Australia.
    function initMap() {
      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 11,
        center: {
          lat: 40.645037,
          lng: -73.880224
        },
      });

      var image = 'images/maps-and-flags.png';
      var beachMarker = new google.maps.Marker({
        position: {
          lat: 40.645037,
          lng: -73.880224
        },
        map: map,
        icon: image
      });
    }
  </script>
  <!-- google map js -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8eaHt9Dh5H57Zh0xVTqxVdBFCvFMqFjQ&callback=initMap">
  </script>
  <!-- end google map js -->
</body>

</html>