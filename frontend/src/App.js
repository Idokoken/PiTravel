import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import ErrorPage from "./pages/ErrorPage";
import Contact from "./pages/Contact";
import About from "./pages/About";
import Careers from "./pages/Careers";
import FAQs from "./pages/FAQs";
import TermsAndConditions from "./pages/TermsAndConditions";
import FlightRoutes from "./pages/FlightRoutes"
import MediaCenter from "./pages/MediaCenter"
import BaggagePolicy from "./pages/BaggagePolicy"
import TravelServices from "./pages/TravelServices";
import BookFlight from "./pages/BookFlight";
import Login from "./pages/Login";
import Register from "./pages/Register";

import AdminDashboard from "./pages/admin/AdminDashboard";
import BookingList from "./pages/admin/bookings/BookingList";
import Checkout from './pages/admin/bookings/Checkout';
import AddPlane from "./pages/admin/plane/AddPlane";
import EditPlane from "./pages/admin/plane/EditPlane"
import SinglePlane from './pages/admin/plane/SinglePlane';
import AddUser from './pages/admin/user/AddUser';
import EditUser from './pages/admin/user/EditUser';
import UserList from './pages/admin/user/UserList';

import ScrollToTop from "./ScrollToTop";
import Gallery from "./pages/Gallery";


function App() {
  return (
    <Router>

      <ScrollToTop />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/contact-us" element={<Contact />} />
        <Route path="/about-us" element={<About />} />
        <Route path="/careers" element={<Careers />} />
        <Route path="/faqs" element={<FAQs />} />
        <Route path="/routes" element={<FlightRoutes />} />
        <Route path="/terms" element={<TermsAndConditions />} />
        <Route path="/media-center" element={<MediaCenter />} />
        <Route path="/travel-services" element={<TravelServices />} />
        <Route path="/baggage-policy" element={<BaggagePolicy />} />
        <Route path="/book-flight" element={<BookFlight />} />
        <Route path="/gallery" element={<Gallery />} />
        <Route path="/signup" element={<Register />} />
        <Route path="/login" element={<Login />} />


        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/bookinglist" element={<BookingList />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="/addplane" element={<AddPlane />} />
        <Route path="/editplane" element={<EditPlane />} />
        <Route path="/planes/{id}" element={<SinglePlane />} />
        <Route path="/user" element={< UserList />} />
        <Route path="/adduser" element={<AddUser />} />
        <Route path="/edituser" element={<EditUser />} />



        <Route path="*" element={<ErrorPage />} />

      </Routes>

    </Router>
  );
}

export default App;