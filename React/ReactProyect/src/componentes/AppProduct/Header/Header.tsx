import { Container, Navbar } from 'react-bootstrap'

export const Header = () => {
    return (
        <Navbar className="bg-body-tertiary">
            <Container>
            <Navbar.Brand href="#home">Carga de Productos</Navbar.Brand>
            </Container>
        </Navbar>
    )
}
