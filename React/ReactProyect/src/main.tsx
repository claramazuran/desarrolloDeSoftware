import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { AppProduct } from './componentes/AppProduct/Header/AppProduct';


createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <AppProduct/>
  </StrictMode>,
)
