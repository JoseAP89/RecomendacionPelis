import StyledFooter from '../styles/styledComponents/styledFooter'

const Footer = () => {

	return (
		<StyledFooter>
            <footer className="footer">
                <div className="container">
                    <div className="row">
                        <div className="footer-col">
                            <h4>Compañia</h4>
                            <ul>
                                <li><a href="#">Sobre nosotros</a></li>
                                <li><a href="#">Nuestros servicios</a></li>
                                <li><a href="#">Política de privacidad</a></li>
                                <li><a href="#"></a></li>
                            </ul>
                        </div>
                        <div className="footer-col">
                            <h4>Ayuda</h4>
                            <ul>
                                <li><a href="#">Preguntas frecuentes</a></li>
                                <li><a href="#">Contáctanos</a></li>
                                <li><a href="#">Cuentra</a></li>
                                <li><a href="#">¿Preguntas? llama al 800-868-5111</a></li>
                                <li><a href="#">¿Cómo puedo buscar?</a></li>
                            </ul>
                        </div>
                        <div className="footer-col">
                            <ul>
                                <li><a href="#">Empleo</a></li>
                                <li><a href="#">Cuenta</a></li>
                                <li><a href="#">Quejas</a></li>
                                <li><a href="#">Envía tus comentarios</a></li>
                            </ul>
                        </div>
                        <div className="footer-col">
                            <h4>Síganos</h4>
                            <div className="social-links">
                                <a href="#"><i className="fab fa-facebook-f"></i></a>
                                <a href="#"><i className="fab fa-twitter"></i></a>
                                <a href="#"><i className="fab fa-instagram"></i></a>
                                <a href="#"><i className="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

		</StyledFooter>
	);
};
export default Footer;