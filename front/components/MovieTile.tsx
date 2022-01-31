
import {StyledNavBar} from '../styles/styledComponents/styledNavBar'
import { useEffect, useState } from 'react';
import { Button, Modal } from 'react-bootstrap';
import Pelicula from '../models/pelicula';
import StyledMovieTile from '../styles/styledComponents/styledMovieTile'

interface PropTile {
	pelicula: Pelicula,
}

const MovieTile = ({pelicula}: PropTile) => {

	return (
		<StyledMovieTile src={pelicula.poster_path}>
            <div className='pelicula-info'>
                <p className='title'>{pelicula.title}</p>
                <p className='overview'>{pelicula.overview}</p>
            </div>
		</StyledMovieTile>
	);
};
export default MovieTile;