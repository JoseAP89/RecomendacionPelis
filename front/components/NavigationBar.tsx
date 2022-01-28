import {StyledNavBar} from '../styles/styledComponents/StyledNavBar'
import Link from 'next/link'
import { useEffect } from 'react';
import Head from 'next/head';
import { Button } from 'react-bootstrap';
import { useRouter } from 'next/router';
import FormaUsuario from '../models/formausuario';

interface PropsUsuario {
	usuario: FormaUsuario | undefined,
}

const NavigationBar = ({usuario}: PropsUsuario) => {
  const router = useRouter()


	function cerrarSesion() {
      sessionStorage.setItem("token","");
      router.push('/');
	}

	return (
		<>
		<Head>
			<script src="https://kit.fontawesome.com/1348fe1b4f.js" crossOrigin="anonymous" ></script>
		</Head>
		<StyledNavBar>


	        <nav id="topnav">
				<div className='tab-nav'>THEMOVIEDB</div>
				<div className='tab-nav' >Bienvenido  	&ensp;
					<div className='info-usuario'>
						<i className="fas fa-user"></i> &ensp; <span id='usuario-alias'></span>
					</div>
				</div>
				<div className="cerrar-sesion">
					<Button variant="danger" onClick={ () => {cerrarSesion()}}>Cerrar sesión</Button> 
				</div>
	        </nav>
      	</StyledNavBar>
		</>
	);
};
export default NavigationBar;