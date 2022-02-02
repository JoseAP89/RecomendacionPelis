import styled from 'styled-components';
interface Props {
    src: string | undefined
}

const StyledMovieTile = styled.div<Props>`
    @import url('https://fonts.googleapis.com/css2?family=DM+Mono:wght@300;500&display=swap');
    font-family: 'DM Mono', monospace;
    background-image : ${ prop => {
       return "url(https://image.tmdb.org/t/p/w500"+prop.src + ")"
    }};
    background-size: 100% 100%;
    background-repeat: no-repeat;
    color: black;
    padding: 10px;;
    border-radius: 10%;
    cursor: pointer;
    .pelicula-info {
        overflow: scroll;
        background-color: gray;
        background-color: rgba(192,192,192, .90);
        max-width: 200px;
        max-height: 100px;
        border-radius: 10%;
        padding: 3px;
        p.title  {
            color: black !important;
            font-size: 20px;
        }
        p.overview {
            color: black !important;
            font-size: 14px;
        }
    }
`;
export default StyledMovieTile;
