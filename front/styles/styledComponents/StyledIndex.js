import styled from 'styled-components';
import Theater from '../../public/images/movie-theater.jpg';

const StyledIndex = styled.div`

    #form-container{

        .select-react {
        width: 280px;
        }

        .form-control.form-control.form-control {
            width: 180px;
        }

        #form-container {
            color: rgb(230, 230, 230);
            width: 100vw;
            padding: 40px 50px 40px 50px;
        }

        /* grid para los campos de crear la nueva cuenta*/

        .forma-crear-cuenta{
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
        }
        @media (max-width: 950px) {
            #form-container {
                width: 100vw;
                padding: 40px 20px 40px 20px;
            }
            .forma-crear-cuenta{
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-column: 10px;
            }
        }
        @media (max-width: 620px) {
            #form-container {
                width: 100vw;
                padding: 40px 10px 40px 10px;
            }
            .forma-crear-cuenta{
                display: grid;
                grid-template-columns: 1fr;
                grid-row: 10px;
                justify-items: center;
            }
        }

    }


`;

export default StyledIndex; 
