<%-- 
    Document   : contactenos
    Created on : 15/06/2014, 06:21:06 PM
    Author     : Karla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/freelancer.css" rel="stylesheet" type="text/css">

        <!-- Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>

<h3>Contáctenos</h3>
            <table border="0">
				<tr>
					<td><label>Nombres:</label></td>
					<td width="32%">
                        <input name="TxtNombre" type="text" id="TxtNombre" tabindex="1" style="width:220px;" /><br />
                        <h:
                                <f:validateLongRange minimum="1" maximun="60" />
                        
                    </td>
					<td><label>País:</label></td>
					<td>
                        <select name="ctl00$ContentPlaceHolder1$ddlPais" onchange="javascript:setTimeout('__doPostBack(\'ctl00$ContentPlaceHolder1$ddlPais\',\'\')', 0)" id="ctl00_ContentPlaceHolder1_ddlPais">
		<option selected="selected" value="-1">Pa&#237;s</option>
		<option value="54">Argentina</option>
		<option value="591">Bolivia</option>
		<option value="55">Brazil</option>
		<option value="56">Chile</option>
		<option value="57">Colombia</option>
		<option value="506">Costa Rica</option>
		<option value="53">Cuba</option>
		<option value="593">Ecuador</option>
		<option value="503">El Salvador</option>
		<option value="502">Guatemala</option>
		<option value="504">Honduras</option>
		<option value="52">Mexico</option>
		<option value="505">Nicaragua</option>
		<option value="507">Panama</option>
		<option value="595">Paraguay</option>
		<option value="51">Per&#250;</option>
		<option value="1809">Republica Dominicana</option>
		<option value="598">Uruguay</option>
		<option value="58">Venezuela</option>
		<option value="0">Otro Pais</option>

	</select>
                        <span id="ctl00_ContentPlaceHolder1_lblErrorPais" style="color:Red;font-size:0.78em;"></span>
			        </td>
			    </tr>
			    <tr>
			        <td><label>Apellido Paterno:</label></td>
			        <td>
                        <input name="ctl00$ContentPlaceHolder1$txtAPaterno" type="text" id="ctl00_ContentPlaceHolder1_txtAPaterno" tabindex="2" style="width:220px;" /><br />
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator2" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Dato requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator2" style="color:Red;font-size:0.67em;display:none;">*Digite solo letras</span>
                    </td>
			        <td><label>Provincia/Región:</label></td>
			        <td>
			           	<select name="ctl00$ContentPlaceHolder1$ddlCiudad" onchange="javascript:setTimeout('__doPostBack(\'ctl00$ContentPlaceHolder1$ddlCiudad\',\'\')', 0)" id="ctl00_ContentPlaceHolder1_ddlCiudad">
		<option selected="selected" value="-1">Seleccionar..</option>

	</select>
                        &nbsp;<span id="ctl00_ContentPlaceHolder1_lblErrorCiudad" style="color:Red;font-size:0.78em;"></span>
			        </td>
			    </tr>
			    <tr>
			        <td><label>Apellido Materno:</label></td>
			        <td>
                        <input name="ctl00$ContentPlaceHolder1$txtAMaterno" type="text" id="ctl00_ContentPlaceHolder1_txtAMaterno" tabindex="3" style="width:220px;" /><br />
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator3" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Dato requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator3" style="color:Red;font-size:0.67em;display:none;">*Digite solo letras</span>
                    </td>
			        <td><label>Teléfono Domicilio:</label></td>
			        <td>
                        <table cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$TxtFono1" type="text" id="ctl00_ContentPlaceHolder1_TxtFono1" disabled="disabled" class="textbox" style="width:50px;" />
                                </td>
                                <td>
                                    -
                                </td>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$TxtFono2" type="text" id="ctl00_ContentPlaceHolder1_TxtFono2" disabled="disabled" class="textbox" style="width:50px;" />
                                </td>
                                <td>
                                    -
                                </td>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$txtTelefono" type="text" id="ctl00_ContentPlaceHolder1_txtTelefono" tabindex="5" style="width:140px;" />
                                </td>
                            </tr>
                            <tr>
                                <td class="texto-tel">
                                    Cod. Pais
                                </td>
                                <td>
                                    -
                                </td>
                                <td class="texto-tel">
                                    Cod. Area
                                </td>
                                <td>
                                    -
                                </td>
                                <td class="texto-tel">
                                    Numero Telefonico
                                </td>
                            </tr>
                        </table>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator9" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*El telefono es requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator9" style="color:Red;font-size:0.67em;display:none;">*Numero de telefono completo</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator14" style="color:Red;font-size:0.67em;display:none;">*Codigo de pais errado</span>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator12" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Codigo de pais es requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator15" style="color:Red;font-size:0.67em;display:none;">*Codigo de Area errado</span>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator13" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Codigo de Area es requerido</span>
                    </td>
			    </tr>
			    <tr>
                    <td>Fecha de Nacimiento:</td>
				    <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <select name="ctl00$ContentPlaceHolder1$ddlDia" id="ctl00_ContentPlaceHolder1_ddlDia" style="width:50px;">
		<option value="-1">Dia</option>
		<option value="01">01</option>
		<option value="02">02</option>
		<option value="03">03</option>
		<option value="04">04</option>
		<option value="05">05</option>
		<option value="06">06</option>
		<option value="07">07</option>
		<option value="08">08</option>
		<option value="09">09</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18">18</option>
		<option value="19">19</option>
		<option value="20">20</option>
		<option value="21">21</option>
		<option value="22">22</option>
		<option value="23">23</option>
		<option value="24">24</option>
		<option value="25">25</option>
		<option value="26">26</option>
		<option value="27">27</option>
		<option value="28">28</option>
		<option value="29">29</option>
		<option value="30">30</option>
		<option value="31">31</option>

	</select>
                                </td>
                                <td>
                                            
                                </td>
                                <td>
                                    <select name="ctl00$ContentPlaceHolder1$ddlMes" id="ctl00_ContentPlaceHolder1_ddlMes" style="width:100px;">
		<option value="-1">Mes</option>
		<option value="01">Enero</option>
		<option value="02">Febrero</option>
		<option value="03">Marzo</option>
		<option value="04">Abril</option>
		<option value="05">Mayo</option>
		<option value="06">Junio</option>
		<option value="07">Julio</option>
		<option value="08">Agosto</option>
		<option value="09">Septiembre</option>
		<option value="10">Octubre</option>
		<option value="11">Noviembre</option>
		<option value="12">Diciembre</option>

	</select>
                                </td>
                                <td>
                                            
                                </td>
                                <td>
                                    <select name="ctl00$ContentPlaceHolder1$ddlAnhio" id="ctl00_ContentPlaceHolder1_ddlAnhio" style="width:60px;">
		<option value="-1">A&#241;o</option>
		<option value="1960">1960</option>
		<option value="1961">1961</option>
		<option value="1962">1962</option>
		<option value="1963">1963</option>
		<option value="1964">1964</option>
		<option value="1965">1965</option>
		<option value="1966">1966</option>
		<option value="1967">1967</option>
		<option value="1968">1968</option>
		<option value="1969">1969</option>
		<option value="1970">1970</option>
		<option value="1971">1971</option>
		<option value="1972">1972</option>
		<option value="1973">1973</option>
		<option value="1974">1974</option>
		<option value="1975">1975</option>
		<option value="1976">1976</option>
		<option value="1977">1977</option>
		<option value="1978">1978</option>
		<option value="1979">1979</option>
		<option value="1980">1980</option>
		<option value="1981">1981</option>
		<option value="1982">1982</option>
		<option value="1983">1983</option>
		<option value="1984">1984</option>
		<option value="1985">1985</option>
		<option value="1986">1986</option>
		<option value="1987">1987</option>
		<option value="1988">1988</option>
		<option value="1989">1989</option>
		<option value="1990">1990</option>
		<option value="1991">1991</option>
		<option value="1992">1992</option>
		<option value="1993">1993</option>
		<option value="1994">1994</option>
		<option value="1995">1995</option>
		<option value="1996">1996</option>
		<option value="1997">1997</option>
		<option value="1998">1998</option>
		<option value="1999">1999</option>
		<option value="2000">2000</option>
		<option value="2001">2001</option>
		<option value="2002">2002</option>
		<option value="2003">2003</option>
		<option value="2004">2004</option>
		<option value="2005">2005</option>
		<option value="2006">2006</option>
		<option value="2007">2007</option>
		<option value="2008">2008</option>
		<option value="2009">2009</option>
		<option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>

	</select>
                                </td>
                            </tr>
                        </table>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator16" style="color:Red;font-size:0.67em;visibility:hidden;">*Dia</span>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator17" style="color:Red;font-size:0.67em;visibility:hidden;">/ *Mes</span>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator18" style="color:Red;font-size:0.67em;visibility:hidden;">/ *Año</span>
				    </td>
			        
			        <td><label>Teléfono Móvil:</label></td>
			        <td>
                        <table cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$TxtCelu1" type="text" id="ctl00_ContentPlaceHolder1_TxtCelu1" disabled="disabled" style="width:50px;" />
                                </td>
                                <td>
                                    -
                                </td>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$TxtCelu2" type="text" id="ctl00_ContentPlaceHolder1_TxtCelu2" disabled="disabled" style="width:60px;" />
                                </td>
                                <td>
                                    -
                                </td>
                                <td>
                                    <input name="ctl00$ContentPlaceHolder1$TxtCelu" type="text" id="ctl00_ContentPlaceHolder1_TxtCelu" style="width:140px;" />
                                </td>
                            </tr>
                            <tr>
                                <td class="texto-tel">
                                    Cod. Pais
                                </td>
                                <td>
                                    -
                                </td>
                                <td class="texto-tel">
                                    Cod. Area
                                </td>
                                <td>
                                    -
                                </td>
                                <td class="texto-tel">
                                    &nbsp; Numero Telefonico
                                </td>
                            </tr>
                        </table>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator10" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*El celular es requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator10" style="color:Red;font-size:0.67em;display:none;">*Numero de celular completo</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator16" style="color:Red;font-size:0.67em;display:none;">*Codigo de pais errado</span>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator14" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Codigo de pais es requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_lblErrorNumeroCelular" style="color:Red;font-size:0.7em;"></span>
                    </td>
			    </tr>
			    <tr>
                    <td><label>Correo electrónico:</label></td>
			        <td>
                        <input name="ctl00$ContentPlaceHolder1$TxtMail" type="text" id="ctl00_ContentPlaceHolder1_TxtMail" tabindex="4" style="width:220px;" /><br />
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator4" style="color:Red;font-size:0.67em;font-style:italic;text-decoration:none;display:none;">*Dato requerido</span>
                        <span id="ctl00_ContentPlaceHolder1_RegularExpressionValidator4" style="color:Red;font-size:0.67em;display:none;">*El e-mail no es valido</span>
                    </td>
			        
			    </tr>

			    <tr>
                    <td>
                        <label>Nivel de Formación:</label>
                    </td>
			        <td>
                        <select name="ctl00$ContentPlaceHolder1$DdlNivelForm" id="ctl00_ContentPlaceHolder1_DdlNivelForm" tabindex="11">
		<option selected="selected" value="-1">Seleccionar</option>
		<option value="Superior Tecnico">Superior Tecnico</option>
		<option value="Superior Universitario">Superior Universitario</option>
		<option value="Estudiante">Estudiante</option>

	</select>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator6" style="color:Red;font-size:0.67em;visibility:hidden;">*Seleccione una opcion</span>
                        
                    </td>
			    </tr>
			    <tr>
                    <td>
                        <label>Área de Formación:</label>
                    </td>
			        <td>
			            <select name="ctl00$ContentPlaceHolder1$DdlArea" id="ctl00_ContentPlaceHolder1_DdlArea" tabindex="12">
		<option value="-1">Seleccionar...</option>
		<option value="Adm. de Empresas">Adm. de Empresas</option>
		<option value="Agronegocios">Agronegocios</option>
		<option value="Arqueología">Arqueolog&#237;a</option>
		<option value="Arquitectura">Arquitectura</option>
		<option value="Comercio Exterior">Comercio Exterior</option>
		<option value="Biología">Biolog&#237;a</option>
		<option value="Biotecnología">Biotecnolog&#237;a</option>
		<option value="Educación">Educaci&#243;n</option>
		<option value="Computación y Afines">Computaci&#243;n y Afines</option>
		<option value="Comunicación y Afines">Comunicaci&#243;n y Afines</option>
		<option value="Construcción">Construcci&#243;n</option>
		<option value="Contabilidad">Contabilidad</option>
		<option value="Derecho">Derecho</option>
		<option value="Diseño de Imagen y Sonido">Dise&#241;o de Imagen y Sonido</option>
		<option value="Diseño de Modas">Dise&#241;o de Modas</option>
		<option value="Diseño Gráfic">Dise&#241;o Gr&#225;fico</option>
		<option value="Diseño Industrial">Dise&#241;o Industrial</option>
		<option value="Economía">Econom&#237;a</option>
		<option value="Electricidad">Electricidad</option>
		<option value="Electrónica">Electr&#243;nica</option>
		<option value="Enfermería">Enfermer&#237;a</option>
		<option value="Farmacia">Farmacia</option>
		<option value="Filosofía">Filosof&#237;a</option>
		<option value="Finanzas y Afines">Finanzas y Afines</option>
		<option value="Gastronomía/Cocina">Gastronom&#237;a/Cocina</option>
		<option value="Geofísica">Geof&#237;sica</option>
		<option value="Geografía">Geograf&#237;a</option>
		<option value="Geología">Geolog&#237;a</option>
		<option value="Topografía">Topograf&#237;a</option>
		<option value="Hidráulica">Hidr&#225;ulica</option>
		<option value="Historia">Historia</option>
		<option value="Hotelería y Afines">Hoteler&#237;a y Afines</option>
		<option value="Informatica y Afines">Informatica y Afines</option>
		<option value="Ing. Agrónomo - Agropecuario">Ing. Agr&#243;nomo - Agropecuario</option>
		<option value="Ing. Alimentos">Ing. Alimentos</option>
		<option value="Ing. Ambiental">Ing. Ambiental</option>
		<option value="Ing. Civil">Ing. Civil</option>
		<option value="Ing. Comercial">Ing. Comercial</option>
		<option value="Ing. Eléctrica">Ing. El&#233;ctrica</option>
		<option value="Ing. Electrónica">Ing. Electr&#243;nica</option>
		<option value="Ing. en Materiales">Ing. en Materiales</option>
		<option value="Ing. en Minas">Ing. en Minas</option>
		<option value="Ing. en Sistemas">Ing. en Sistemas</option>
		<option value="Ing. Forestal">Ing. Forestal</option>
		<option value="Ing. Hidráulica">Ing. Hidr&#225;ulica</option>
		<option value="Ing. Industrial">Ing. Industrial</option>
		<option value="Ing. Informática">Ing. Inform&#225;tica</option>
		<option value="Ing. Mecánica">Ing. Mec&#225;nica</option>
		<option value="Ing. Metalúrgica">Ing. Metal&#250;rgica</option>
		<option value="Ing. Pesquera">Ing. Pesquera</option>
		<option value="Ing. Petróleo">Ing. Petr&#243;leo</option>
		<option value="Ing. Química">Ing. Qu&#237;mica</option>
		<option value="Ing. Recursos Hídricos">Ing. Recursos H&#237;dricos</option>
		<option value="Ing. Sonido">Ing. Sonido</option>
		<option value="Ing. Telecomunicaciones">Ing. Telecomunicaciones</option>
		<option value="Mantenimiento y Afines">Mantenimiento y Afines</option>
		<option value="Marketing y Afines">Marketing y Afines</option>
		<option value="Mecánica y Afines">Mec&#225;nica y Afines</option>
		<option value="Medicina y Afines">Medicina y Afines</option>
		<option value="Metalmecanica y Afines">Metalmecanica y Afines</option>
		<option value="Música">M&#250;sica</option>
		<option value="Negocios y Afines">Negocios y Afines</option>
		<option value="Nutrición">Nutrici&#243;n</option>
		<option value="Odontología y Afines">Odontolog&#237;a y Afines</option>
		<option value="Periodismo">Periodismo</option>
		<option value="Programación y Afines">Programaci&#243;n y Afines</option>
		<option value="Produccion y Afines">Produccion y Afines</option>
		<option value="Psicología">Psicolog&#237;a</option>
		<option value="Publicidad y Afines">Publicidad y Afines</option>
		<option value="Química">Qu&#237;mica</option>
		<option value="Relaciones Públicas">Relaciones P&#250;blicas</option>
		<option value="Secretariado y Afines">Secretariado y Afines</option>
		<option value="Tecnología de Alimentos">Tecnolog&#237;a de Alimentos</option>
		<option value="Tecnología Médica/Laboratorio">Tecnolog&#237;a M&#233;dica/Laboratorio</option>
		<option value="Tecnologías de la Información">Tecnolog&#237;as de la Informaci&#243;n</option>
		<option value="Telecomunicaciones">Telecomunicaciones</option>
		<option value="Trabajo Social">Trabajo Social</option>
		<option value="Turismo">Turismo</option>
		<option value="Veterinaria">Veterinaria</option>

	</select>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator5" style="color:Red;font-size:0.67em;visibility:hidden;">*Seleccione una opcion</span>
                        
			        </td>
			        
			    </tr>
                <tr>
                    <td><label>¿Cómo llegó aquí?</label></td>
			        <td>
			           	<select name="ctl00$ContentPlaceHolder1$DdlComoEntero" id="ctl00_ContentPlaceHolder1_DdlComoEntero" tabindex="10">
		<option value="-1">Seleccionar</option>
		<option value="232">Redes sociales</option>
		<option value="45">Publicidad</option>
		<option value="46">B&#250;squeda en Google</option>
		<option value="4">Referencia de un Tercero</option>

	</select>
                        <span id="ctl00_ContentPlaceHolder1_RequiredFieldValidator7" style="color:Red;font-size:0.67em;visibility:hidden;">*Seleccione una opcion</span>
                        
			        </td>
                </tr>
			    <tr>
			        <td><label>Consulta:</label></td>
			        <td colspan="3">
                        <textarea name="ctl00$ContentPlaceHolder1$TxtConsulta" rows="5" cols="60" id="ctl00_ContentPlaceHolder1_TxtConsulta" tabindex="13" onkeyup="textCounter(this, this.form.remLen, 300);" onkeydown="textCounter(this, this.form.remLen, 300);" style="height:60px;width:300px;"></textarea>
                            <input readonly="readonly" type="text" name="remLen" maxlength="3" value="300" style="width: 20px;
                                font-size: 0.80em" disabled="disabled" />
                    </td>
			    </tr>
			    <tr>                             
                                
			    </tr>
			</table>
                           <div class="row-fluid "> 
        <div class="span12 form-actions">
            <div class="control-group">
                <div class="controls">
                    <div class="text-center">
                        <!--<input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Alquilar"> &nbsp;-->                                                                                                               
                         <a class="btn btn-info fa-input right" href="WEB-INF/registrado.jsp">Enviar Datos</a>
                        <a class="btn btn-info fa-input right" href="inicio.jsp">Regresar al inicio</a>   
                    </div>
                </div> 
            </div>

        </div>
    </div>
        
    </body>
    
    <footer class="text-center">
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; 2014 - @Karla @Meli
                    </div>
                </div>
            </div>
        </div>
    </footer>
    
</html>
