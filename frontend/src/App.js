import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ErrorPage from "./pages/ErrorPage";
import Contact from "./pages/Contact";
import About from "./pages/About";
import Careers from "./pages/Careers";
import FAQs from "./pages/FAQs";
import TermsAndConditions from "./pages/TermsAndConditions";
import FlightRoutes from "./pages/FlightRoutes"
import MediaCenter from "./pages/MediaCenter"
import BaggagePolicy from "./pages/BaggagePolicy"

import ScrollToTop from "./ScrollToTop"


function App() {
  return (
    <Router>

      <Header />
      
      <ScrollToTop />
      
      <Routes>
        <Route path="/" element={<Home />} />
       <Route path="/contact" element={<Contact />} />  
       <Route path="/about" element={<About />} />  
       <Route path="/careers" element={<Careers />} />  
       <Route path="/faqs" element={<FAQs />} /> 
        <Route path="/routes" element={<FlightRoutes />} />  
       <Route path="/terms" element={<TermsAndConditions />} /> 
        <Route path="/media-center" element={<MediaCenter />} /> 
        <Route path="/baggage-policy" element={<BaggagePolicy />} />
        
        <Route path="*" element={<ErrorPage />} />
        
      </Routes>
      
      <Footer />
    </Router>
  );
}

export default App;