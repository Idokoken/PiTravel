import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ErrorPage from "./pages/ErrorPage";
// import ImageSlider from "./components/ImageSlider";

function App() {
  return (
    <Router>

      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        {/* <Route path="/slide" element={<ImageSlider />} /> */}
        <Route path="*" element={<ErrorPage />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
