import {StyledNavBar} from './Styled'
import Link from 'next/link'
import { useEffect } from 'react';

interface NavigationElement {
  title: string;
  url: string;
}

const NavigationBar = () => {

	
	const menuList : Array<NavigationElement> = [
	    { title: "Inicio", url: "/"},
	    { title: "Alta", url: "/signup"},
	    { title: "Apertura", url: "/opensavingsaccount"},
	    { title: "Transacciones", url: "/transactions"}
	 ];

	return (
		<StyledNavBar>
	        <div id="topnav">
	          { menuList.map( (m,i) =>{
	              return (
	              	<Link href={m.url} key={i}>
	              		<a className="tab-nav" style={{color:"blue"}}>{m.title}</a>
	              	</Link>
	              )
	            })
	          }
	        </div>
      	</StyledNavBar>
	);
};
export default NavigationBar;