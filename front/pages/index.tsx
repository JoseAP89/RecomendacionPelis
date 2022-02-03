import type { NextPage } from 'next'
import Head from 'next/head'
import { useRouter } from 'next/router'
import { useEffect, useRef, useState } from 'react'
import { Container, Form, Button, Alert} from 'react-bootstrap'
import { Controller, useForm } from "react-hook-form";
import Box from '../models/box';
import TransactionService from '../services/transaction';
import Select from 'react-select';
import FormaUsuario from '../models/formausuario'
import Cuenta from '../models/cuenta';
import StyleIndex from '../styles/styledComponents/styledIndex'
import Theater from '../public/images/movie-theater.jpg';


const Index: NextPage = () => {
  const router = useRouter()
  const [cuenta, setCuenta] = useState<boolean>(true);
  const { getValues: getValuesConCuenta, register: regConCuenta, handleSubmit: handleSubmitConCuenta, formState: { errors : errorsConCuenta} } = useForm();
  const { reset, control,register: regSinCuenta, handleSubmit: handleSubmitSinCuenta, formState: { errors : errorsSinCuenta} } = useForm();
  const [generos, setGeneros] = useState<Array<Box>>([]);
  const [formaUsuario, setFormaUsuario] = useState<FormaUsuario>();

  // busqueda actores
  const [searchActor, setSearchActor] = useState<string|null>(null);
  const [actores, setActores] = useState<Array<Box>>([]);

  // busqueda directores
  const [searchDir, setSearchDir] = useState<string|null>(null);
  const [dir, setDir] = useState<Array<Box>>([]);

  // busqueda peliculas
  const [searchPeli, setSearchPeli] = useState<string|null>(null);
  const [peli, setPeli] = useState<Array<Box>>([]);

  // chequeo de contraseñas
  const [password1, setPassword1] = useState<string>("");
  const [password2, setPassword2] = useState<string>("");

  // alertas en el post de agregar usuario, si positivo mensaje de exito, si neg mensaje de error, si null no se muestra nada
  const [postUsuarioStatus, setPostUsuarioStatus] = useState<boolean|null>(null);
  const [postUsuarioRegistradoStatus, setUsuarioRegistradoStatus] = useState<boolean|null>(null);

  // refs a los react-select 
  const selectInputDir = useRef<any>();
  const selectInputActor = useRef<any>();
  const selectInputGenre = useRef<any>();
  const selectInputPeli = useRef<any>();

	useEffect(() => {
    if (generos.length==0) {
      TransactionService.getGeneros().then((resp) =>{
        setGeneros(resp.data);
      }).catch((error)=>{
        console.log(error);
      });
    }
	}, []);
	
  useEffect(() => {
    if (searchActor!=null) {
      // busca los actores desde la api
      TransactionService.getPersonas(searchActor).then((resp) =>{
          setActores(resp.data);
        }).catch((error)=>{
          console.log(error);
        });
    }
  }, [searchActor]);
  
  useEffect(() => {
    if (searchDir!=null) {
      // busca los directores desde la api
      TransactionService.getPersonas(searchDir).then((resp) =>{
          setDir(resp.data);
        }).catch((error)=>{
          console.log(error);
        });
    }
  }, [searchDir]);
  
  useEffect(() => {
    if (searchPeli!=null) {
      // busca las peliculas desde la api
      TransactionService.getPeliculas(searchPeli).then((resp) =>{
          setPeli(resp.data);
        }).catch((error)=>{
          console.log(error);
        });
    }
  }, [searchPeli]);
  
  const onSubmitSinCuenta = (data: any) => {
    let usuario : FormaUsuario = {
      nombre : data.nombre,
      apellido1: data.apellido1,
      apellido2: data.apellido2,
      correo: data.correo,
      alias: data.alias,
      edad: data.edad == "" ? "-1" : data.edad,
      genero: data.genero.lenght > 1 ? "X": data.genero,
      password: data.password1,
      dir_favorito_id: data.dir_favorito.value,
      dir_favorito_nombre: data.dir_favorito.label,
      actor_favorito_id: data.actor_favorito.value,
      actor_favorito_nombre: data.actor_favorito.label,
      genero_favorito_id: data.genero_favorito.value,
      genero_favorito_nombre: data.genero_favorito.label,
      peli_favorita_id: data.peli_favorita.value,
      peli_favorita_nombre: data.peli_favorita.label
    };
    TransactionService.addUsuario(usuario).then((res) => {
        setPostUsuarioStatus(true);
        reset();
        selectInputPeli.current.setValue("");
        selectInputDir.current.setValue("");
        selectInputActor.current.setValue("");
        selectInputGenre.current.setValue("");
    }).catch((err) => {
        setPostUsuarioStatus(false);
    }).finally(()=>{
      setTimeout(() => {
        setPostUsuarioStatus(null);
      }, 1_000 * 5);
    })
  }


  const onSubmitConCuenta = (data: any) => {
    let cuenta : Cuenta = {
      alias_correo: data.alias_correo,
      password: data.password
    }
    TransactionService.checkUsuario(cuenta).then((res) => {
      setUsuarioRegistradoStatus(true);
      // cambia pagina a /home si se identifico correctamente el usuario
      sessionStorage.setItem("token",res.data); // guarda el token
      router.push('/home');
    }).catch((err) => {
      setUsuarioRegistradoStatus(false);
      sessionStorage.setItem("token","");
    }).finally(()=>{
      setTimeout(() => {
        setUsuarioRegistradoStatus(null);
      }, 1_000 * 5);
    })
  }

  return (
    <StyleIndex>
      <Head>
        <title>Inicio</title>
        <meta name="description" content="Generated by create next app" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      
      <div id='canvas'></div>

      <section id='form-container' className='p-5' style={{backgroundImage:"url("+Theater+")"}}>
      
        <h3>Bienvenido!</h3>
          { cuenta &&
            <p style={{paddingBottom:"20px"}}>
              Inicie sesión si ya tiene una cuenta, o <span className='enlace' onClick={() => setCuenta(!cuenta)}>cree una nueva</span>.
            </p>
          }
          { !cuenta &&
            <p style={{paddingBottom:"20px"}}>
              LLene sus datos para crear su cuenta, o <span className='enlace' onClick={() => setCuenta(!cuenta)}>inicie sesión </span>
              si ya tiene una.
            </p>
          }

        { cuenta &&
          <Form className='forma-iniciar-sesion mt-4'  onSubmit={handleSubmitConCuenta(onSubmitConCuenta)}>


              <Form.Group className="mb-3 sesion-nombre" controlId="sesion-nombre">
                <Form.Label>Alias o correo electronico <span className="field-required">*</span></Form.Label>
                <Form.Control type="text" style={{width:"280px"}}
                  {...regConCuenta("alias_correo", { required: true})}
                />
              </Form.Group>

              <Form.Group className="mb-3 sesion-password" controlId="sesion-password">
                <Form.Label>Contraseña <span className="field-required">*</span></Form.Label>
                <Form.Control type="password" style={{width:"280px"}}
                  {...regConCuenta("password", { required: true})}
                />
              </Form.Group>

              <Button  className="my-4" type="submit">Enviar</Button>

          </Form>
        }

        { !cuenta &&
          <Form className='mt-4' onSubmit={handleSubmitSinCuenta(onSubmitSinCuenta)}>
            <h4 className='my-4'>Datos de la cuenta</h4>
            <div className='forma-crear-cuenta'>

              <Form.Group className="mb-3 input-sincuenta forma-nombre" controlId="forma-nombre">
                <Form.Label>Nombre de usuario <span className="field-required">*</span></Form.Label>
                <Form.Control type="text" style={{width:"280px"}}
                  {...regSinCuenta("nombre", { required: true})}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta apellido1" controlId="apellido1">
                <Form.Label>Apellido Paterno <span className="field-required">*</span></Form.Label>
                <Form.Control type="text" style={{width:"280px"}}
                  {...regSinCuenta("apellido1", { required: true})}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta apellido2" controlId="apellido2">
                <Form.Label>Apellido Materno</Form.Label>
                <Form.Control type="text" style={{width:"280px"}}
                  {...regSinCuenta("apellido2")}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-correo" controlId="forma-correo">
                <Form.Label>Correo <span className="field-required">*</span></Form.Label>
                <Form.Control type="email" style={{width:"280px"}}
                  {...regSinCuenta("correo", { required: true})}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-alias" controlId="forma-alias">
                <Form.Label>Alias <span className="field-required">*</span></Form.Label>
                <Form.Control type="text" style={{width:"280px"}}
                  {...regSinCuenta("alias", { required: true})}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-edad" controlId="forma-edad">
                <Form.Label>Edad</Form.Label>
                <Form.Control type="number" style={{width:"280px"}} step="1" min="0" max="99"
                  {...regSinCuenta("edad")}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-edad" controlId="forma-genero">
                <Form.Label>Género</Form.Label>
                <Form.Select aria-label="Default select example" style={{width:"280px"}}
                  {...regSinCuenta("genero")}
                >
                  <option value="X">Selecciona una opción</option>
                  <option value="F">Femenino</option>
                  <option value="M">Masculino</option>
                </Form.Select>
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-password1" controlId="forma-password1">
                <Form.Label>Contraseña <span className="field-required">*</span></Form.Label>
                <Form.Control type="password" style={{width:"280px", 
                  border: (password1!=password2 && !!password1 && !!password2?"4px solid #ff3333":"")}} 
                  {...regSinCuenta("password1", { required: true})}
                  onKeyUp={(data: any)=> {setPassword1(data.target.value)}}
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta forma-password2" controlId="forma-password2">
                <Form.Label>Confirmar Contraseña <span className="field-required">*</span></Form.Label>
                <Form.Control type="password" style={{width:"280px",
                  border: (password1!=password2 && !!password1 && !!password2?"4px solid #ff3333":"")}} 
                  {...regSinCuenta("password2", { required: true})}
                  onKeyUp={(data: any)=> {setPassword2(data.target.value)}}
                />
              </Form.Group>
            </div>

            <hr />

            <h4 className='my-4'>Tus Preferencias cinéfilas</h4>

            <div className='forma-crear-cuenta'>

              <Form.Group className="mb-3 input-sincuenta pref-genero" controlId="pref-genero">
                <Form.Label>Selecciona tú género favorito <span className="field-required">*</span></Form.Label>
                <Controller
                  name="genero_favorito"
                  control={control}
		              rules={{ required: true }}
                  render={({ field }) => 
                    <Select 
                      {...field} 
                      className="select-react"
                      escapeClearsValue={true}
                      isClearable={true}
                      isSearchable={true}
                      ref={selectInputGenre}
                      options=
                      {
                        generos.map((genero: Box) =>{
                          return {label:genero.name, value: genero.id}
                        })
                      }
                      styles={{
                        option: (provided, state) => ({
                          ...provided,
                          borderBottom: '1px dotted pink',
                          color: state.isSelected ? 'white' : 'black',
                          padding: 6,
                        })
                      }}
                    />
                  }
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta pref-genero" controlId="pref-genero">
                <Form.Label>Selecciona tú actor favorito <span className="field-required" >*</span></Form.Label>
                <Controller
                  name="actor_favorito"
                  control={control}
		              rules={{ required: true }}
                  render={({ field }) => 
                    <Select 
                      {...field} 
                      onInputChange={(value)=> setSearchActor(value.replaceAll(/\s+/g,"+"))}
                      className="select-react"
                      escapeClearsValue={true}
                      ref={selectInputActor}
                      isClearable={true}
                      isSearchable={true}
                      options=
                      {
                        actores.map((persona: Box) =>{
                          return {label:persona.name, value: persona.id}
                        })
                      }
                      styles={{
                        option: (provided, state) => ({
                          ...provided,
                          borderBottom: '1px dotted pink',
                          color: state.isSelected ? 'white' : 'black',
                          padding: 6,
                        })
                      }}
                    />
                  }
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta pref-genero" controlId="pref-genero">
                <Form.Label>Selecciona tú director favorito <span className="field-required" >*</span></Form.Label>
                <Controller
                  name="dir_favorito"
                  control={control}
		              rules={{ required: true }}
                  render={({ field }) => 
                    <Select 
                      {...field} 
                      className="select-react"
                      onInputChange={(value)=> setSearchDir(value.replaceAll(/\s+/g,"+"))}
                      isSearchable={true}
                      ref={selectInputDir}
                      isClearable={true}
                      escapeClearsValue={true}
                      options=
                      {
                        dir.map((persona: Box) =>{
                          return {label:persona.name, value: persona.id}
                        })
                      }
                      styles={{
                        option: (provided, state) => ({
                          ...provided,
                          borderBottom: '1px dotted pink',
                          color: state.isSelected ? 'white' : 'black',
                          padding: 6,
                        })
                      }}
                    />
                  }
                />
              </Form.Group>

              <Form.Group className="mb-3 input-sincuenta pref-genero" controlId="pref-genero">
                <Form.Label>Selecciona tú Pelicula favorito <span className="field-required" >*</span></Form.Label>
                <Controller
                  name="peli_favorita"
                  control={control}
		              rules={{ required: true }}
                  render={({ field }) => 
                    <Select 
                      {...field} 
                      className="select-react"
                      ref={selectInputPeli}
                      onInputChange={(value)=> setSearchPeli(value.replaceAll(/\s+/g,"+"))}
                      isSearchable={true}
                      isClearable={true}
                      escapeClearsValue={true}
                      options=
                      {
                        peli.map((pelicula: Box) =>{
                          return {label:pelicula.title, value: pelicula.id}
                        })
                      }
                      styles={{
                        option: (provided, state) => ({
                          ...provided,
                          borderBottom: '1px dotted pink',
                          color: state.isSelected ? 'white' : 'black',
                          padding: 6,
                        })
                      }}
                    />
                  }
                />
              </Form.Group>

            </div>

            <Button  className='my-4' type="submit" disabled={!(!!errorsSinCuenta && Object.keys(errorsSinCuenta).length == 0 && password1==password2)}>Enviar</Button>

          </Form>
        }

        { postUsuarioStatus === true && 
          <Alert  variant="success">
            <p>El usuario {formaUsuario?.nombre.toUpperCase()} ha sido creado correctamente.</p>
          </Alert>
        }
        { postUsuarioStatus === false && 
          <Alert  variant="danger">
            <p>Ha habido un error creando su usuario.</p>
          </Alert>
        }
        { postUsuarioRegistradoStatus === false && 
          <Alert  variant="danger">
          <p>Error. Verifique su usuario y contraseña</p>
          </Alert>
        }
      </section>

    </StyleIndex>
  )
}

export default Index;
