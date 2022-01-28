import {StyledNavBar} from '../styles/styledComponents/StyledNavBar'
import Link from 'next/link'
import { useEffect, useState } from 'react';
import Head from 'next/head';
import { Button, Modal } from 'react-bootstrap';
import { useRouter } from 'next/router';
import FormaUsuario from '../models/formausuario';

interface PropsUsuario {
	usuario: FormaUsuario | undefined,
}

const NavigationBar = ({usuario}: PropsUsuario) => {
	const router = useRouter()
	const [show, setShow] = useState(false);

	const handleClose = () => setShow(false);
	const handleShow = () => setShow(true);


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
					<div className='info-usuario' onClick={handleShow}>
						<i className="fas fa-user"></i> &ensp; <span id='usuario-alias'></span>
					</div>
				</div>
				<div className="cerrar-sesion">
					<Button variant="danger" onClick={ () => {cerrarSesion()}}>Cerrar sesión</Button> 
				</div>
	        </nav>
      	</StyledNavBar>

		<div className="modal-container">
			<Modal show={show} onHide={handleClose} >
				<Modal.Header closeButton>
					<Modal.Title>Información de cuenta</Modal.Title>
				</Modal.Header>
				<Modal.Body >
					<div>Alias : {usuario?.alias}</div>
					<div>Nombre: {usuario?.nombre}</div>
					<div>Apellido Paterno: {usuario?.apellido1}</div>
					<div>Apellido Materno: {usuario?.apellido2}</div>
					<div>Correo : {usuario?.correo}</div>
					<div>Edad : {usuario?.edad == "-1" ? "" : usuario?.edad}</div>
				</Modal.Body>
				<Modal.Footer>
				<Button variant="secondary" onClick={handleClose}>
					Cerrar
				</Button>
				</Modal.Footer>
			</Modal>
		</div>

		</>
	);
};
export default NavigationBar;