import '../styles/globals.css'
import type { AppProps } from 'next/app'
import 'bootstrap/dist/css/bootstrap.css'
import NavigationBar from '../components/NavigationBar/Index'

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <>
      <NavigationBar/>
      <Component {...pageProps} />
    </> 
  ) 
}

export default MyApp
