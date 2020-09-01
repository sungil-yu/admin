package com.oncerun.admin.controller.api;

import com.oncerun.admin.controller.CrudController;
import com.oncerun.admin.domain.entity.Partner;
import com.oncerun.admin.domain.network.request.PartnerApiRequest;
import com.oncerun.admin.domain.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {



}
