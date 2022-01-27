import axios from 'axios';
import Cuenta from '../models/cuenta';
import FormaUsuario from '../models/formausuario';

const TransactionService = {
    getGeneros,
    getPersonas,
    getPeliculas,
    addUsuario,
    checkUsuario
}

const backendsrc = "http://localhost:8080"

/*
async function createClient(data: Client): Promise<any>{
    const url = `${backendsrc}/api/BankOps/client`;
    // Default options are marked with *
    console.log(data);
    return axios.post(url,data);
}

async function createAccount(data: Account): Promise<any>{
    const url = `${backendsrc}/api/BankOps/account`;
    // Default options are marked with *
    console.log(data);
    return axios.post(url,data);
}

async function updateAccount(data: Account): Promise<any>{
    const url = `${backendsrc}/api/BankOps/account/${data.accountid}`;
    // Default options are marked with *
    console.log(data);
    return axios.put(url,data);
}
*/
async function getGeneros(): Promise<any>{
    const url = `${backendsrc}/api/generos`;
    // Default options are marked with *
    return axios.get(url);
}

async function getPersonas(persona: string): Promise<any>{
    const url = `${backendsrc}/api/personas`;
    // Default options are marked with *
    return axios.get(url, {params:{name:persona}});
}

async function getPeliculas(title: string): Promise<any>{
    const url = `${backendsrc}/api/peliculas`;
    // Default options are marked with *
    return axios.get(url, {params:{title}});
}

async function addUsuario(data: FormaUsuario): Promise<any>{
    const url = `${backendsrc}/api/usuario`;
    // Default options are marked with *
    return axios.post(url,data);
}

async function checkUsuario(data: Cuenta): Promise<any>{
    const url = `${backendsrc}/api/usuario/access`;
    // Default options are marked with *
    return axios.post(url,data);
}

export default TransactionService;