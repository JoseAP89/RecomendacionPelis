import axios, { AxiosResponse, AxiosResponseHeaders } from 'axios';
import Box from '../models/box';
import Cuenta from '../models/cuenta';
import FormaUsuario from '../models/formausuario';

const TransactionService = {
    getGeneros,
    getPersonas,
    getPeliculas,
    getRecomendacion,
    addUsuario,
    checkUsuario,
    checkToken,
    getUsuario,
    getRecomendacionby
}

const backendsrc = "http://localhost:8080"

async function getGeneros(): Promise<AxiosResponse<Array<Box>>>{
    const url = `${backendsrc}/api/generos`;
    // Default options are marked with *
    return axios.get(url);
}

async function getPersonas(persona: string): Promise<AxiosResponse<Array<Box>>>{
    const url = `${backendsrc}/api/personas`;
    // Default options are marked with *
    return axios.get(url, {params:{name:persona}});
}

async function getPeliculas(title: string): Promise<AxiosResponse<Array<Box>>>{
    const url = `${backendsrc}/api/peliculas`;
    // Default options are marked with *
    return axios.get(url, {params:{title}});
}
<<<<<<< HEAD
async function getRecomendacion(user_id: string): Promise<any>{
    const url = `${backendsrc}/api/peliculas/recomendacion`;
    // Default options are marked with *
    return axios.get(url, {params: {user_id}});
}
async function addUsuario(data: FormaUsuario): Promise<any>{
=======

async function getUsuario(token: string): Promise<AxiosResponse<FormaUsuario>>{
    const url = `${backendsrc}/api/usuario`;
    // Default options are marked with *
    return axios.get(url,{params:{token}});
}


async function addUsuario(data: FormaUsuario): Promise<AxiosResponse<string>>{
>>>>>>> main
    const url = `${backendsrc}/api/usuario`;
    // Default options are marked with *
    return axios.post(url,data);
}

async function checkUsuario(data: Cuenta): Promise<AxiosResponse<string>>{
    const url = `${backendsrc}/api/usuario/access`;
    // Default options are marked with *
    return axios.post(url,data);
}

async function checkToken(token: string): Promise<AxiosResponse<string>>{
    const url = `${backendsrc}/api/usuario/verificacion`;
    // Default options are marked with *
    return axios.get(url,{params:{token}});
}

async function getRecomendacionby(token : string, tipoDeRecomendacion : string): Promise<any>{
    const url = `${backendsrc}/api/peliculas/recomendacion`;
    // Default options are marked with *
    return axios.get(url, {params: {token, tipoDeRecomendacion}});
}

export default TransactionService;