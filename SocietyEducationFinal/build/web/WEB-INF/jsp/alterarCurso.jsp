<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Curso</title>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/feather/feather.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/typicons/typicons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resourcesPainel/assets//js/select.dataTables.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resourcesPainel/assets//css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resourcesPainel/assets//images/favicon.png" />
  </head>
  <body class="with-welcome-text">

<script src="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/js/vendor.bundle.base.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/chart.js/chart.umd.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//vendors/progressbar.js/progressbar.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/off-canvas.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/template.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/settings.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/hoverable-collapse.js"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/jquery.cookie.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resourcesPainel/assets//js/dashboard.js"></script>

    <div class="container-scroller">
      <div class="row p-0 m-0 proBanner" id="proBanner">
        <div class="col-md-12 p-0 m-0">
          <div class="card-body card-body-padding px-3 d-flex align-items-center justify-content-between">
            <div class="ps-lg-3">
              
            </div>
            
          </div>
        </div>
      </div>
      <!-- partial:partials/_navbar.html -->
      <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex align-items-top flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
          <div class="me-3">
            <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-bs-toggle="minimize">
              <span class="icon-menu"></span>
            </button>
          </div>
          <div>
            <a class="navbar-brand brand-logo" href="index.html">
              <img src="${pageContext.request.contextPath}/resourcesPainel/assets//images/logo.svg" alt="logo" />
            </a>
            <a class="navbar-brand brand-logo-mini" href="index.html">
              <img src="${pageContext.request.contextPath}/resourcesPainel/assets//images/logo-mini.svg" alt="logo" />
            </a>
          </div>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-top">
          <ul class="navbar-nav">
            <li class="nav-item fw-semibold d-none d-lg-block ms-0">
              <h1 class="welcome-text">Bem vindo(a), <span class="text-black fw-bold">Society Education</span></h1>
              <h3 class="welcome-sub-text">Sistema de gestão de ocorrências disciplinares </h3>
            </li>
          </ul>
          <ul class="navbar-nav ms-auto">
            
            
            
            

            <li class="nav-item dropdown d-none d-lg-block user-dropdown">
              <a class="nav-link" id="UserDropdown" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                <img class="img-xs rounded-circle" src="${pageContext.request.contextPath}/resourcesPainel/assets//images/faces/face8.jpg" alt="Profile image"> </a>
              <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                <div class="dropdown-header text-center">
                  <img class="img-md rounded-circle" src="${pageContext.request.contextPath}/resourcesPainel/assets//images/faces/face8.jpg" alt="Profile image">
                  <p class="mb-1 mt-3 fw-semibold">Sansa Education</p>
                  <p class="fw-light text-muted mb-0">Sansa@gmail.com</p>
                </div>
                
                  <a class="dropdown-item" href="painel"><i class="dropdown-item-icon mdi mdi-power text-primary me-2"></i>Sign Out</a>
              </div>
            </li>
          </ul>
          <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-bs-toggle="offcanvas">
            <span class="mdi mdi-menu"></span>
          </button>
        </div>
      </nav>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link" href="painel">
                                <i class="mdi mdi-grid-large menu-icon"></i>
                                <span class="menu-title">Principal</span>
                            </a>
                        </li>
                        <!-- Gerenciamento de Alunos -->
                        <li class="nav-item nav-category">Gerenciamento</li>

                        <!-- Alunos -->
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-alunos" aria-expanded="false" aria-controls="ui-alunos">
                                <i class="menu-icon mdi mdi-floor-plan"></i>
                                <span class="menu-title">Aluno</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-alunos">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="alterarAluno">Alterar Aluno</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="consultarUmAluno">Consultar Um Aluno</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="removerAluno">Remover Aluno</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="inserirAluno">Inserir Aluno</a></li>
                                </ul>
                            </div>
                        </li>

                        <!-- Curso -->
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-cursos" aria-expanded="false" aria-controls="ui-cursos">
                                <i class="menu-icon mdi mdi-book-open-page-variant"></i>
                                <span class="menu-title">Curso</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-cursos">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="alterarCurso">Alterar Curso</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="consultarUmCurso">Consultar Um Curso</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="removerCurso">Remover Curso</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="inserirCurso">Inserir Curso</a></li>
                                </ul>
                            </div>
                        </li>


                        <!-- Responsável -->
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-responsavel" aria-expanded="false" aria-controls="ui-responsavel">
                                <i class="menu-icon mdi mdi-account"></i>
                                <span class="menu-title">Responsável</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-responsavel">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="alterarResponsavel">Alterar Responsável</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="consultarUmResponsavel">Consultar Um Responsável</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="removerResponsavel">Remover Responsável</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="inserirResponsavel">Inserir Responsável</a></li>
                                </ul>
                            </div>
                        </li>

                        <!-- Turma -->
                        <li class="nav-item">
                            <a class="nav-link" data-bs-toggle="collapse" href="#ui-turma" aria-expanded="false" aria-controls="ui-turma">
                                <i class="menu-icon mdi mdi-school"></i>
                                <span class="menu-title">Turma</span>
                                <i class="menu-arrow"></i>
                            </a>
                            <div class="collapse" id="ui-turma">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"> <a class="nav-link" href="alterarTurma">Alterar Turma</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="consultarUmaTurma">Consultar Uma Turma</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="removerTurma">Remover Turma</a></li>
                                    <li class="nav-item"> <a class="nav-link" href="inserirTurma">Inserir Turma</a></li>
                                </ul>
                            </div>
                        </li>

                        <!-- Ocorrência -->
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-ocorrencia" aria-expanded="false" aria-controls="ui-ocorrencia">
                <i class="menu-icon mdi mdi-alert"></i>
                <span class="menu-title">Ocorrência</span>
                <i class="menu-arrow"></i>
              </a>
              <div class="collapse" id="ui-ocorrencia">
                                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="alterarOcorrencia">Alterar Ocorrência</a></li>
                  <li class="nav-item"> <a class="nav-link" href="consultarUmaOcorrencia">Consultar Uma Ocorrência</a></li>
                  <li class="nav-item"> <a class="nav-link" href="removerOcorrencia">Remover Ocorrência</a></li>
                  <li class="nav-item"> <a class="nav-link" href="inserirOcorrencia">Inserir Ocorrência</a></li>
                </ul>
              </div>
            </li>

            <!-- Penalidade -->
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-penalidade" aria-expanded="false" aria-controls="ui-penalidade">
                <i class="menu-icon mdi mdi-gavel"></i>
                <span class="menu-title">Penalidade</span>
                <i class="menu-arrow"></i>
              </a>
              <div class="collapse" id="ui-penalidade">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="alterarPenalidade">Alterar Penalidade</a></li>
                  <li class="nav-item"> <a class="nav-link" href="consultarUmaPenalidade">Consultar Uma Penalidade</a></li>
                  <li class="nav-item"> <a class="nav-link" href="removerPenalidade">Remover Penalidade</a></li>
                  <li class="nav-item"> <a class="nav-link" href="inserirPenalidade">Inserir Penalidade</a></li>
                </ul>
              </div>
            </li>

            <!-- Funcionário -->
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-funcionario" aria-expanded="false" aria-controls="ui-funcionario">
                <i class="menu-icon mdi mdi-account-multiple"></i>
                <span class="menu-title">Funcionário</span>
                <i class="menu-arrow"></i>
              </a>
              <div class="collapse" id="ui-funcionario">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="alterarFuncionario">Alterar Funcionário</a></li>
                  <li class="nav-item"> <a class="nav-link" href="consultarUmFuncionario">Consultar Um Funcionário</a></li>
                  <li class="nav-item"> <a class="nav-link" href="removerFuncionario">Remover Funcionário</a></li>
                  <li class="nav-item"> <a class="nav-link" href="inserirFuncionario">Inserir Funcionário</a></li>
                </ul>
              </div>
            </li>

            <!-- Aluno-Turma -->
            <li class="nav-item">
              <a class="nav-link" data-bs-toggle="collapse" href="#ui-alunoTurma" aria-expanded="false" aria-controls="ui-alunoTurma">
                <i class="menu-icon mdi mdi-account-group"></i>
                <span class="menu-title">Aluno-Turma</span>
                <i class="menu-arrow"></i>
              </a>
              <div class="collapse" id="ui-alunoTurma">
                
        <ul class="nav flex-column sub-menu">
            <li class="nav-item"> <a class="nav-link" href="alterarAlunoTurma">Alterar Aluno-Turma</a></li>
            <li class="nav-item"> <a class="nav-link" href="consultarUmAlunoTurma">Consultar Um Aluno-Turma</a></li>
            <li class="nav-item"> <a class="nav-link" href="removerAlunoTurma">Remover Aluno-Turma</a></li>
            <li class="nav-item"> <a class="nav-link" href="inserirAlunoTurma">Inserir Aluno-Turma</a></li>
        </ul>
        </nav>
        <!-- partial -->
        
        <!-- main-panel ends -->
     


    <div class="container mt-5">
        <div class="container-box">
            <div class="row">
                <div class="col-md-6">
                    <h2>Alterar Curso</h2>
                    <form:form method="POST" onsubmit="${pageContext.request.contextPath}/alterarCurso" modelAttribute="curso" id="formAlterarCurso">
                        

                        <div class="mb-3">
                            <form:label path="nome_curso" class="form-label">Nome do Curso</form:label>
                            <form:input path="nome_curso" type="text" class="form-control" required="required" />
                        </div>

                        <div class="mb-3">
                            <form:label path="sigla" class="form-label">Sigla</form:label>
                            <form:input path="sigla" type="text" class="form-control" required="required" />
                        </div>

                        <button type="submit" class="btn btn-primary">Alterar</button>
                    
                </div>

                <div class="col-md-6">
                    <div class="border p-4 h-100 conr">
                        <h3>Selecione o curso</h3>
                        <br>
                             
                                <form:select path="cod_curso" class="form-select">
                                   <form:option value="0" label="Selecionar"/>
                                    <form:options items="${webConsultarCursos}" />
                                </form:select>
                        <br>
                            <center>${resultado}</center>
                    </div>
                </div>
            </div>
                    </form:form>
        </div>
    </div>
</body>
</html>
