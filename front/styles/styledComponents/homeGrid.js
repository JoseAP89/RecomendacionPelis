import styled from 'styled-components';

const HomeGrid = styled.div`
    @import url('https://fonts.googleapis.com/css2?family=DM+Mono:wght@300;500&display=swap');

    #wrapper-home {
        p , h2, h3, h4, h5 {
            font-family: 'DM Mono', monospace;
        }
        background-color: #242124;
        color: white;

        .movie-grid {
            display: grid;
            grid-template-columns: 3fr 1fr;
            column-gap: 10px;
            .movie-recomendacion {
                border-radius: 30px;
                padding: 8px;
                .mosaic {
                    padding: 8px;
                    p {
                        color: white;
                    }
                    font-weight: bold;
                    display: grid;
                    grid-template-columns: 1fr 1fr 1fr;
                    grid-auto-rows: 300px;
                    gap: 10px;

                }
            }
            .person-recomendacion {
                padding: 8px;
                border-radius: 30px;
                background-color: #989898;
                color: black;
                .title {
                    color:black;
                    font-weight: bold;
                }
                .mosaic {
                    display: grid;
                    grid-template-columns: 1fr;
                    grid-auto-rows: 250px;
                    row-gap: 10px;

                }
            }

        }

        @media (max-width: 950px) {
            .movie-grid{
                display: grid;
                grid-template-columns: 2fr 1fr;
                grid-column: 10px;
                .movie-recomendacion {
                    .mosaic {
                        p {
                            color: white;
                        }
                        display: grid;
                        grid-template-columns: 1fr 1fr;
                        grid-auto-rows: 200px;
                        column-gap: 10px;

                    }
                }
            }
        }
        @media (max-width: 620px) {
            .movie-grid{
                display: grid;
                grid-template-columns: 1fr;
                grid-row: 10px;
                justify-items: center;
                .movie-recomendacion {
                    .mosaic {
                        p {
                            color: white;
                        }
                        display: grid;
                        grid-template-columns: 1fr ;
                        grid-auto-rows: 200px;
                        column-gap: 10px;

                    }
                }
            }
        }
    }


`;
export default HomeGrid;
