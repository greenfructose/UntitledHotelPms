package com.example.untitledhotelpms.bootstrap;

import com.example.untitledhotelpms.domain.AppUser;
import com.example.untitledhotelpms.domain.RoomType;
import com.example.untitledhotelpms.domain.UserRole;
import com.example.untitledhotelpms.service.AppUserService;
import com.example.untitledhotelpms.service.RoomTypeService;
import com.example.untitledhotelpms.service.UserRoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppUserService appUserService;
    private final UserRoleService userRoleService;
    private final RoomTypeService roomTypeService;

    public DataLoader(AppUserService appUserService, UserRoleService userRoleService, RoomTypeService roomTypeService) {
        this.appUserService = appUserService;
        this.userRoleService = userRoleService;
        this.roomTypeService = roomTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = appUserService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        UserRole admin = UserRole.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("ADMIN")
                .build();

        userRoleService.save(admin);
        System.out.println("Created UserRole: " + admin.getName());

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(admin);

        AppUser user1 = AppUser.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .firstName("Jerry")
                .lastName("Fallwell")
                .email("jf@gmail.com")
                .phone("4175555555")
                .address1("123 Easy St")
                .address2("")
                .city("Anytown")
                .state("Indiana")
                .country("United States")
                .postalCode("75486")
                .userRoles(userRoles)
                .build();

        appUserService.save(user1);
        System.out.println("Created AppUser: " + user1.getFirstName());

        RoomType doubleQueen = RoomType.builder()
                .id(1L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("Double Queen")
                .description("Two Queen Sized Beds")
                .kingBeds(0L)
                .queenBeds(2L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(0L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(false)
                .handicapAccessible(false)
                .smoking(false)
                .build();

        RoomType singleKing = RoomType.builder()
                .id(2L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("Single King")
                .description("One King Sized Bed")
                .kingBeds(1L)
                .queenBeds(0L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(0L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(false)
                .handicapAccessible(false)
                .smoking(false)
                .build();

        RoomType kingSuite = RoomType.builder()
                .id(3L)
                .createdBy("loadData")
                .createdDate(new Date())
                .lastModifiedBy("loadData")
                .lastModifiedDate(new Date())
                .deleted(false)
                .name("King Suite")
                .description("One King Sized Bed and Sofa Sleeper")
                .kingBeds(1L)
                .queenBeds(0L)
                .fullBeds(0L)
                .twinBeds(0L)
                .infantBeds(0L)
                .sofaBeds(1L)
                .hasFridge(true)
                .hasMicrowave(true)
                .hasKitchenette(true)
                .handicapAccessible(true)
                .smoking(false)
                .build();

        roomTypeService.save(doubleQueen);
        System.out.println("Created RoomType: " + doubleQueen.getName());
        roomTypeService.save(singleKing);
        System.out.println("Created RoomType: " + singleKing.getName());
        roomTypeService.save(kingSuite);
        System.out.println("Created RoomType: " + kingSuite.getName());
    }
}
