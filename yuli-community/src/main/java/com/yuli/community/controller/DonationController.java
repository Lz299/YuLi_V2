package com.yuli.community.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.yuli.community.domain.Donation;
import com.yuli.community.service.IDonationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 捐赠管理Controller
 * 
 * @author lz
 * @date 2024-04-27
 */
@RestController
@RequestMapping("/community/donation")
public class DonationController extends BaseController
{
    @Autowired
    private IDonationService donationService;

    /**
     * 查询捐赠管理列表
     */
    @PreAuthorize("@ss.hasPermi('community:donation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Donation donation)
    {
        startPage();
        List<Donation> list = donationService.selectDonationList(donation);
        return getDataTable(list);
    }

    /**
     * 导出捐赠管理列表
     */
    @PreAuthorize("@ss.hasPermi('community:donation:export')")
    @Log(title = "捐赠管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Donation donation)
    {
        List<Donation> list = donationService.selectDonationList(donation);
        ExcelUtil<Donation> util = new ExcelUtil<Donation>(Donation.class);
        util.exportExcel(response, list, "捐赠管理数据");
    }

    /**
     * 获取捐赠管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:donation:query')")
    @GetMapping(value = "/{donationId}")
    public AjaxResult getInfo(@PathVariable("donationId") Long donationId)
    {
        return success(donationService.selectDonationByDonationId(donationId));
    }

    /**
     * 新增捐赠管理
     */
    @PreAuthorize("@ss.hasPermi('community:donation:add')")
    @Log(title = "捐赠管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Donation donation)
    {
        return toAjax(donationService.insertDonation(donation));
    }

    /**
     * 修改捐赠管理
     */
    @PreAuthorize("@ss.hasPermi('community:donation:edit')")
    @Log(title = "捐赠管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Donation donation)
    {
        return toAjax(donationService.updateDonation(donation));
    }

    /**
     * 删除捐赠管理
     */
    @PreAuthorize("@ss.hasPermi('community:donation:remove')")
    @Log(title = "捐赠管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{donationIds}")
    public AjaxResult remove(@PathVariable Long[] donationIds)
    {
        return toAjax(donationService.deleteDonationByDonationIds(donationIds));
    }
}
