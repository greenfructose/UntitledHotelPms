package com.example.untitledhotelpms.controller;

import com.example.untitledhotelpms.domain.Reservation;
import com.example.untitledhotelpms.domain.RoomType;
import com.example.untitledhotelpms.service.ReservationService;
import com.example.untitledhotelpms.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final RoomTypeService roomTypeService;

    public ReservationController(ReservationService reservationService, RoomTypeService roomTypeService) {
        this.reservationService = reservationService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/{id}")
    public ModelAndView showReservation(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("reservations/reservationDetail");
        mav.addObject("reservation", reservationService.findById(id));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("reservation", Reservation.builder().build());
        Set<RoomType> roomTypes = new HashSet<>(roomTypeService.findAll());
        model.addAttribute("roomTypes", roomTypes);
        return "reservations/createOrUpdateReservationForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Reservation reservation,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "reservations/createOrUpdateReservationForm";
        } else {
            Reservation savedReservation = reservationService.save(reservation);
            return "redirect:/reservations/" + savedReservation.getId();
        }
    }

    @GetMapping("/{id}/edit")
    public String initUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute(reservationService.findById(id));
        return "reservations/createOrUpdateReservationForm";
    }

    @PostMapping("/{id}/edit")
    public String processUpdateForm(@Validated Reservation reservation, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "reservations/createOrUpdateReservationForm";
        } else {
            reservation.setId(id);
            Reservation savedReservation = reservationService.save(reservation);
            return "redirect:/reservations/" + savedReservation.getId();
        }
    }
}
