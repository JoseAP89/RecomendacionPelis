import styled from 'styled-components';

const StyledNavBar = styled.div`
#topnav{
    background-color:#333;
    height: 40px;
    height: 60px;
    display: flex;
    flex-direction: row;
}
#topnav div.tab-nav{
    display: flex;
    align-items: center;
      
}
#topnav div.tab-nav {
    color: white !important;
    padding: 20px;
    font-size: 20px;
} 

.fa-user {
    color: white;
}
.cerrar-sesion {
    position: absolute;
    right: 15px;
    padding-top: 8px;
}

@media (max-width: 600px) { 
	#topnav{
		display: flex;
	    flex-direction: column;
	    height:fit-content;
	}
    
    #topnav div.tab-nav{
        height: 36px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

}

`;

export {StyledNavBar}; 
